package com.bfi.backend.interfaces;

import com.bfi.backend.entites.AccountOffer;

import java.util.List;
import java.util.Optional;

public interface IAccountOffer {
    List<AccountOffer> getAll();
    Optional<AccountOffer> getAccountOfferById(Long id);
    void saveAccountOffer(AccountOffer accountOffer);
    void updateAccountOffer(Long id, AccountOffer accountOffer);
}
