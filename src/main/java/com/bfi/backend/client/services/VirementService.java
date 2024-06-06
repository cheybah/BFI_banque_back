package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Virement;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.client.repositories.VirementRepository;
import com.bfi.backend.common.exceptions.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Service
public class VirementService {

    private static final Logger logger = LoggerFactory.getLogger(VirementService.class);

    @Autowired
    private VirementRepository virementRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public Virement createVirement(Long clientId, String compteAdebiter, String compteAcrediter, Double montant, Long motif) {
        logger.debug("Creating virement with compteAdebiter: {}, compteAcrediter: {}, montant: {}, motif: {}", compteAdebiter, compteAcrediter, montant, motif);

        BankAccount compteDebiteur = bankAccountRepository.findByRib(compteAdebiter)
                .orElseThrow(() -> new AppException("Compte à débiter non trouvé", HttpStatus.NOT_FOUND));
        BankAccount compteCrediteur = bankAccountRepository.findByRib(compteAcrediter)
                .orElseThrow(() -> new AppException("Compte à créditer non trouvé", HttpStatus.NOT_FOUND));

        logger.debug("Found compteDebiteur: {}", compteDebiteur);
        logger.debug("Found compteCrediteur: {}", compteCrediteur);

        // Check solde of debiteur account
        if (compteDebiteur.getSolde() < montant) {
            throw new AppException("Solde insuffisant", HttpStatus.NOT_ACCEPTABLE);
        }

        // Create Virement
        Virement virement = Virement.builder()
                .date(new Date())
                .mantant(montant)
                .motif(motif)
                .compteADebite(compteAdebiter)
                .compteACrediter(compteAcrediter)
                .build();

        // Update solde
        compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
        compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);

        bankAccountRepository.save(compteDebiteur);
        bankAccountRepository.save(compteCrediteur);

        return virementRepository.save(virement);
    }

    public List<Virement> getVirementsByBankAccountRib(String rib) {
        return virementRepository.findByCompteADebiteOrCompteACrediter(rib, rib);
    }
}
