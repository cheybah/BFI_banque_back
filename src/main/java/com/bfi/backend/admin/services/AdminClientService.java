package com.bfi.backend.admin.services;

import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminClientDto;
import com.bfi.backend.admin.entities.AdminClient;
import com.bfi.backend.admin.mappers.AdminClientMapper;
import com.bfi.backend.admin.repository.AdminClientRepository;
import com.bfi.backend.admin.dtos.AdminCredentialsDto;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.common.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminClientService {

    @Autowired
    private ClientRepository ClientRepository;
    private final AdminClientRepository adminClientRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminClientMapper adminClientMapper;

    public AdminClientDto login(AdminCredentialsDto adminCredentialsDto) {
        AdminClient adminClient = adminClientRepository.findByLogin(adminCredentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown admin Client", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(adminCredentialsDto.password()), adminClient.getPassword())) {
            return adminClientMapper.toAdminClientDto(adminClient);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public AdminClientDto register(AdminSignUpDto adminSignUpDto) {
        Optional<AdminClient> optionalAdminClient = adminClientRepository.findByLogin(adminSignUpDto.login());

        if (optionalAdminClient.isPresent()) {
            throw new AppException("Clientname already exists", HttpStatus.BAD_REQUEST);
        }

        AdminClient adminClient = adminClientMapper.signUpToAdminClient(adminSignUpDto);
        adminClient.setPassword(passwordEncoder.encode(CharBuffer.wrap(adminSignUpDto.password())));

        AdminClient savedAdminClient = adminClientRepository.save(adminClient);

        return adminClientMapper.toAdminClientDto(savedAdminClient);
    }

    public AdminClientDto findByLogin(String login) {
        AdminClient adminClient = adminClientRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown Client", HttpStatus.NOT_FOUND));
        return adminClientMapper.toAdminClientDto(adminClient);
    }


    public List<Client> getAllClients() {
        return ClientRepository.findByStatus(true);
    }
    /*
    public void deleteClient(Long id) {
        ClientRepository.deleteById(id);
    }
*/


    public void deleteClient(Long id) {
        Optional<Client> optionalClient = ClientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client Client = optionalClient.get();
            Client.setStatus(false);
            ClientRepository.save(Client);
        } else {
            throw new AppException("Client not found", HttpStatus.NOT_FOUND);
        }
    }
   // Assuming you have a repository for Archived_App_Client


    public List<Client> getAllArchivedClients() {
        return ClientRepository.findByStatus(false);
    }
}
