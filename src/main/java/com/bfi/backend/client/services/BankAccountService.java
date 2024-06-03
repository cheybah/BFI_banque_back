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

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper; // Use ClientMapper instead of BankAccountMapper

    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
            Client Client = clientRepository.findById(bankAccountDto.getClientId())
                .orElseThrow(() -> new AppException("Client not found", HttpStatus.NOT_FOUND));

        BankAccount bankAccount = clientMapper.toBankAccount(bankAccountDto);
        bankAccount.setClient(Client);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        // Save the Client entity after adding the BankAccount to it
        clientRepository.save(Client);

        return clientMapper.toBankAccountDto(savedBankAccount);
    }
    public Optional<BankAccount> getBankAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public List<BankAccount> getBankAccountsByClientId(Long clientId) {
        return bankAccountRepository.findByClientId(clientId);
    }
}
