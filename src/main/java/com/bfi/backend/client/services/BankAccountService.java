package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.BankAccountDto;
import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.mappers.ClientMapper;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.common.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository ClientRepository;
    private final ClientMapper ClientMapper; // Use ClientMapper instead of BankAccountMapper

    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
            Client Client = ClientRepository.findById(bankAccountDto.getClientId())
                .orElseThrow(() -> new AppException("Client not found", HttpStatus.NOT_FOUND));

        BankAccount bankAccount = ClientMapper.toBankAccount(bankAccountDto);
        bankAccount.setClient(Client);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Save the Client entity after adding the BankAccount to it
        ClientRepository.save(Client);

        return ClientMapper.toBankAccountDto(savedBankAccount);
    }
}
