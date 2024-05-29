package com.bfi.backend.client.controllers;

import com.bfi.backend.client.dtos.BankAccountDto;
import com.bfi.backend.client.dtos.CredentialsDto;
import com.bfi.backend.client.auth.ClientAuthenticationProvider;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.SignUpPersonnePhysiqueDto;
import com.bfi.backend.client.dtos.SignUpPersonneMoraleDto;

import com.bfi.backend.client.dtos.ClientDto;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.client.services.BankAccountService;
import com.bfi.backend.client.services.ClientService;
import com.bfi.backend.common.exceptions.AppException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final ClientService ClientService;
    private final BankAccountService bankAccountService;

    private final ClientAuthenticationProvider ClientAuthenticationProvider;
    private final ClientRepository ClientRepository;


    @PostMapping("/bfi/login")
    public ResponseEntity<ClientDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        ClientDto ClientDto = ClientService.login(credentialsDto);
        ClientDto.setToken(ClientAuthenticationProvider.createToken(ClientDto));
        return ResponseEntity.ok(ClientDto);
    }
/*
    @PostMapping("/dash/informations-personelles")
    public ResponseEntity<ClientDto> register(@RequestBody @Valid SignUpDto Client) {
        ClientDto createdClient = ClientService.register(Client);
        // Create bank accounts for the Client
        for (BankAccountDto bankAccountDto : Client.bankAccounts()) {
            bankAccountDto.setClientId(createdClient.getId());
            bankAccountService.createBankAccount(bankAccountDto);
        }

        // Retrieve the updated Client
        createdClient = ClientService.findByLogin(Client.login());


        createdClient.setToken(ClientAuthenticationProvider.createToken(createdClient));
        System.out.println("Created Client: " + createdClient); // Add this line to print the created Client
        return ResponseEntity.created(URI.create("/Clients/" + createdClient.getId())).body(createdClient);
    }*/


    @PostMapping("/register/personne-physique")
    public ResponseEntity<ClientDto> registerPersonnePhysique(@RequestBody @Valid SignUpPersonnePhysiqueDto ClientDto) {
        ClientDto createdClient = ClientService.register(ClientDto);

        // Create bank accounts for the Client
        for (BankAccountDto bankAccountDto : ClientDto.bankAccounts()) {
            bankAccountDto.setClientId(createdClient.getId());
            bankAccountService.createBankAccount(bankAccountDto);
        }

        createdClient.setToken(ClientAuthenticationProvider.createToken(createdClient));
        return ResponseEntity.created(URI.create("/Clients/" + createdClient.getId())).body(createdClient);
    }

    @PostMapping("/register/personne-morale")
    public ResponseEntity<ClientDto> registerPersonneMorale(@RequestBody @Valid SignUpPersonneMoraleDto ClientDto) {
        ClientDto createdClient = ClientService.register(ClientDto);

        // Create bank accounts for the Client
        for (BankAccountDto bankAccountDto : ClientDto.bankAccounts()) {
            bankAccountDto.setClientId(createdClient.getId());
            bankAccountService.createBankAccount(bankAccountDto);
        }

        createdClient.setToken(ClientAuthenticationProvider.createToken(createdClient));
        return ResponseEntity.created(URI.create("/Clients/" + createdClient.getId())).body(createdClient);
    }
    @PutMapping("/reset")
    public ResponseEntity<ClientDto> resetPassword(@RequestBody Map<String, String> resetRequest) {
        String login = resetRequest.get("login");
        String newPassword = resetRequest.get("newpassword");

        // Call the resetPassword method of the ClientService
        ClientService.resetPassword(login, newPassword);

        // Retrieve updated Client details
        ClientDto updatedClient = ClientService.findByLogin(login);

        // Regenerate token for the updated Client
        String newToken = ClientAuthenticationProvider.createToken(updatedClient);
        updatedClient.setToken(newToken);

        return ResponseEntity.ok(updatedClient);
    }
    @GetMapping("/Clients/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id) {
        Optional<Client> optionalClient = ClientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client Client = optionalClient.get();
            Hibernate.initialize(Client.getAddress()); // Explicitly initialize the address
            return ResponseEntity.ok(Client); // Wrap the Client in ResponseEntity and return
        } else {
            throw new AppException("Client not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailExistence(@RequestParam String email) {
        boolean exists = ClientService.checkEmailExistence(email);
        return ResponseEntity.ok(Collections.singletonMap("exists", exists));
    }


}
