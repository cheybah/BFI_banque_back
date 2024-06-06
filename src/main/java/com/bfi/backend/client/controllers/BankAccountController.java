package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/bankaccounts")

public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<BankAccount>> getBankAccountsByClientId(@PathVariable Long clientId) {
        List<BankAccount> bankAccounts = bankAccountService.getBankAccountsByClientId(clientId);
        if (bankAccounts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bankAccounts);
    }
    @PostMapping("/client/{clientId}")
    public ResponseEntity<BankAccount> addBankAccountToClient(@PathVariable Long clientId, @RequestBody BankAccount bankAccount) {
        BankAccount newBankAccount = bankAccountService.addBankAccountToClient(clientId, bankAccount);
        return ResponseEntity.ok(newBankAccount);
    }
}
