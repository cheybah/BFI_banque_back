package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Depot;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.client.repositories.DepotRepository;
import com.bfi.backend.common.exceptions.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepotService {

    private final BankAccountRepository bankAccountRepository;
    private final DepotRepository depotRepository;

    @Autowired
    public DepotService(BankAccountRepository bankAccountRepository, DepotRepository depotRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.depotRepository = depotRepository;
    }
    public List<Depot> getAllDepots() {

        return depotRepository.findAll(); // Utilisation de JpaRepository ou autre
    }
    public Depot makeDeposit(Double montant, String ribDepotCompteSource, String depot_option, String motif) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findByRib(ribDepotCompteSource);
        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();

            // Vérifiez si le solde est null
            Double solde = bankAccount.getSolde();
            if (solde == null) {
                solde = 0.0; // Initialisez le solde à 0.0 si c'est null
            }

            // Création de l'opération de dépôt
            Depot depot = Depot.builder()
                    .montant(montant)
                    .date(new Date()) // Supposons que la date est fixée à la date actuelle
                    .motif(Long.valueOf(motif)) // Assurez-vous que motif est bien un long
                    .depot_compte_source(ribDepotCompteSource)
                    .depot_option(depot_option)
                    .bankaccount(bankAccount)
                    .build();

            // Mise à jour du solde du compte bancaire
            Double newSolde = solde + montant;
            bankAccount.setSolde(newSolde);
            bankAccountRepository.save(bankAccount);

            // Enregistrement de l'opération de dépôt
            return depotRepository.save(depot);
        } else {
            throw new AppException("Bank account not found with RIB: " + ribDepotCompteSource,HttpStatus.NOT_FOUND);
        }
    }
    public Depot requestDeposit(Double montant, String ribDepotCompteSource, String depot_option, String motif) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findByRib(ribDepotCompteSource);
        if (optionalBankAccount.isPresent()) {
            BankAccount bankAccount = optionalBankAccount.get();

            Double solde = bankAccount.getSolde();
            if (solde == null) {
                solde = 0.0;
            }

            Depot depot = Depot.builder()
                    .montant(montant)
                    .date(new Date())
                    .motif(Long.valueOf(motif))
                    .depot_compte_source(ribDepotCompteSource)
                    .depot_option(depot_option)
                    .bankaccount(bankAccount)
                    .isApproved(false)
                    .build();

            return depotRepository.save(depot);
        } else {
            throw new AppException("Bank account not found with RIB: " + ribDepotCompteSource, HttpStatus.NOT_FOUND);
        }
    }
    public Depot approveDeposit(Long depotId) {
        Optional<Depot> optionalDepot = depotRepository.findById(depotId);
        if (optionalDepot.isPresent()) {
            Depot depot = optionalDepot.get();
            if (!depot.getIsApproved()) {
                BankAccount bankAccount = depot.getBankaccount();
                Double newSolde = bankAccount.getSolde() + depot.getMontant();
                bankAccount.setSolde(newSolde);
                bankAccountRepository.save(bankAccount);

                depot.setIsApproved(true);
                return depotRepository.save(depot);
            } else {
                throw new AppException("Deposit is already approved", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new AppException("Deposit not found with ID: " + depotId, HttpStatus.NOT_FOUND);
        }
    }
    public Depot rejectDeposit(Long depotId) {
        Optional<Depot> optionalDepot = depotRepository.findById(depotId);
        if (optionalDepot.isPresent()) {
            Depot depot = optionalDepot.get();
            if (!depot.getIsApproved()) {
                BankAccount bankAccount = depot.getBankaccount();

                bankAccountRepository.save(bankAccount);

                return depotRepository.save(depot);
            } else {
                throw new AppException("Deposit is already rejected", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new AppException("Deposit not found with ID: " + depotId, HttpStatus.NOT_FOUND);
        }
    }

}
