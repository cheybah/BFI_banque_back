package com.bfi.backend.controllers;

import com.bfi.backend.entites.AccountOffer;
import com.bfi.backend.services.AccountOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/dash/offres-et-domicialisation", produces = "application/json")
    public class AccountOfferController {

    private final AccountOfferService accountOfferService;

    @Autowired
    public AccountOfferController(AccountOfferService accountOfferService) {
        this.accountOfferService = accountOfferService;
    }

    @GetMapping
    public ResponseEntity<List<AccountOffer>> getAllAccountOffers() {
        List<AccountOffer> accountOffers = accountOfferService.getAll();
        return ResponseEntity.ok(accountOffers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountOffer> getAccountOfferById(@PathVariable("id") Long id) {
        Optional<AccountOffer> accountOffer = accountOfferService.getAccountOfferById(id);
        return accountOffer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AccountOffer> saveAccountOffer(@RequestBody AccountOffer accountOffer) {
        accountOfferService.saveAccountOffer(accountOffer);
        return new ResponseEntity<>(accountOffer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountOffer> updateAccountOffer(@PathVariable("id") Long id, @RequestBody AccountOffer accountOffer) {
        accountOfferService.updateAccountOffer(id, accountOffer);
        return new ResponseEntity<>(accountOffer, HttpStatus.OK);
    }
}
