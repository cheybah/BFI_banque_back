package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByClientId(Long clientId);
         Optional<BankAccount> getBankAccountById(Long aLong);
}

