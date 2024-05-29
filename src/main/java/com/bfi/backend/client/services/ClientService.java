package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.*;
import com.bfi.backend.client.entites.*;
import com.bfi.backend.client.mappers.ClientMapper;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.common.exceptions.AppException;
import com.bfi.backend.client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository ClientRepository;

    private final BankAccountRepository bankAccountRepository;

    private final PasswordEncoder passwordEncoder;

    private final ClientMapper ClientMapper;

    public ClientDto login(CredentialsDto credentialsDto) {
        Client Client = ClientRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown Client", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), Client.getPassword())) {
            return ClientMapper.toClientDto(Client);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }


    public ClientDto register(SignUpPersonnePhysiqueDto ClientDto) {
        Optional<Client> optionalClient = ClientRepository.findByLogin(ClientDto.login());

        if (optionalClient.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        PersonnePhysique Client = ClientMapper.signUpToPersonnePhysique(ClientDto);
        Client.setStatus(true);
        Client.setPassword(passwordEncoder.encode(CharBuffer.wrap(ClientDto.password())));

        // Handle address
        Address address = new Address();
        address.setCountry(ClientDto.address().getCountry());
        address.setCity(ClientDto.address().getCity());
        address.setNeighbourhood(ClientDto.address().getNeighbourhood());
        address.setZipCode(ClientDto.address().getZipCode());
        Client.setAddress(address);
        address.setClient(Client);

        // Handle additional info
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setTypeIndividual(ClientDto.additionalInfo().getTypeIndividual());
        additionalInfo.setProfession(ClientDto.additionalInfo().getProfession());
        additionalInfo.setPieceType(ClientDto.additionalInfo().getPieceType());
        additionalInfo.setPieceNumber(ClientDto.additionalInfo().getPieceNumber());
        additionalInfo.setExpirationDate(ClientDto.additionalInfo().getExpirationDate());
        additionalInfo.setPiecePhoto(ClientDto.additionalInfo().getPiecePhoto());
        additionalInfo.setReferralCode(ClientDto.additionalInfo().getReferralCode());
        Client.setAdditionalInfo(additionalInfo);
        additionalInfo.setClient(Client);

        PersonnePhysique savedClient = ClientRepository.save(Client);

        return ClientMapper.toPersonnePhysiqueDto(savedClient);
    }

    public ClientDto register(SignUpPersonneMoraleDto ClientDto) {
        Optional<Client> optionalClient = ClientRepository.findByLogin(ClientDto.login());

        if (optionalClient.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        PersonneMorale Client = ClientMapper.signUpToPersonneMorale(ClientDto);
        Client.setStatus(true);
        Client.setPassword(passwordEncoder.encode(CharBuffer.wrap(ClientDto.password())));

        // Handle address
        Address address = new Address();
        address.setCountry(ClientDto.address().getCountry());
        address.setCity(ClientDto.address().getCity());
        address.setNeighbourhood(ClientDto.address().getNeighbourhood());
        address.setZipCode(ClientDto.address().getZipCode());
        Client.setAddress(address);
        address.setClient(Client);

        // Handle additional info
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setTypeIndividual(ClientDto.additionalInfo().getTypeIndividual());
        additionalInfo.setProfession(ClientDto.additionalInfo().getProfession());
        additionalInfo.setPieceType(ClientDto.additionalInfo().getPieceType());
        additionalInfo.setPieceNumber(ClientDto.additionalInfo().getPieceNumber());
        additionalInfo.setExpirationDate(ClientDto.additionalInfo().getExpirationDate());
        additionalInfo.setPiecePhoto(ClientDto.additionalInfo().getPiecePhoto());
        additionalInfo.setReferralCode(ClientDto.additionalInfo().getReferralCode());
        Client.setAdditionalInfo(additionalInfo);
        additionalInfo.setClient(Client);

        PersonneMorale savedClient = ClientRepository.save(Client);

        return ClientMapper.toPersonneMoraleDto(savedClient);
    }


    public ClientDto findByLogin(String login) {
        Client Client = ClientRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown Client", HttpStatus.NOT_FOUND));
        return ClientMapper.toClientDto(Client);
    }

    public void resetPassword(String login, String newPassword) {
        // Encrypt the new password
        String encryptedPassword = passwordEncoder.encode(newPassword);

        // Retrieve the Client by login
        Client Client = ClientRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Client with provided login does not exist", HttpStatus.NOT_FOUND));

        // Update the Client's password with the encrypted one
        Client.setPassword(encryptedPassword);
        ClientRepository.save(Client);
    }


   public Optional<Client> findById(Long id) {
        return ClientRepository.findById(id);
    }




    public boolean checkEmailExistence(String email) {
        return ClientRepository.findByEmail(email).isPresent();
    }

}
