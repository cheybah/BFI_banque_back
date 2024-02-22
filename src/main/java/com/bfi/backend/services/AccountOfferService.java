package com.bfi.backend.services;

import com.bfi.backend.entites.AccountOffer;
import com.bfi.backend.interfaces.IAccountOffer;
import com.bfi.backend.repositories.AccountOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountOfferService implements IAccountOffer {

    private final AccountOfferRepository accountOfferRepository;

    @Autowired
    public AccountOfferService(AccountOfferRepository accountOfferRepository) {
        this.accountOfferRepository = accountOfferRepository;
    }

    @Override
    public List<AccountOffer> getAll() {
        return accountOfferRepository.findAll();
    }

    @Override
    public Optional<AccountOffer> getAccountOfferById(Long id) {
        return accountOfferRepository.findById(id);
    }

    @Override
    public void saveAccountOffer(AccountOffer accountOffer) {
        accountOfferRepository.save(accountOffer);
    }

    @Override
    public void updateAccountOffer(Long id, AccountOffer accountOffer) {
        AccountOffer existingAccountOffer = accountOfferRepository.findById(id).orElse(null);

        if (existingAccountOffer != null) {
            existingAccountOffer.setAgencyName(accountOffer.getAgencyName());
            existingAccountOffer.setAccountType(accountOffer.getAccountType());
            existingAccountOffer.setPackType(accountOffer.getPackType());

            accountOfferRepository.save(existingAccountOffer);
        } else {
            throw new IllegalArgumentException("L'offre ayant cet id " + id + "n'existe pas");
        }
    }
}
