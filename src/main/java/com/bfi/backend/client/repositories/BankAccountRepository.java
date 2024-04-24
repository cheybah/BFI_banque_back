package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}

