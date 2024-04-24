package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.BankAccountDto;
import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.mappers.UserMapper;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.client.repositories.UserRepository;
import com.bfi.backend.common.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper; // Use UserMapper instead of BankAccountMapper

    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
            User user = userRepository.findById(bankAccountDto.getUserId())
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        BankAccount bankAccount = userMapper.toBankAccount(bankAccountDto);
        bankAccount.setUser(user);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Save the User entity after adding the BankAccount to it
        userRepository.save(user);

        return userMapper.toBankAccountDto(savedBankAccount);
    }
}
