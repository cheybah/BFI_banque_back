package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.auth.AdminClientAuthenticationProvider;
import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminClientDto;
import com.bfi.backend.admin.services.AdminClientService;
import com.bfi.backend.admin.dtos.AdminCredentialsDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AdminAuthController {

    private final AdminClientService adminClientService;
    private final AdminClientAuthenticationProvider adminClientAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<AdminClientDto> login(@RequestBody @Valid AdminCredentialsDto admincredentialsDto) {
        AdminClientDto adminClientDto = adminClientService.login(admincredentialsDto);
        adminClientDto.setToken(adminClientAuthenticationProvider.createToken(adminClientDto));
        return ResponseEntity.ok(adminClientDto);
    }

    @PostMapping("/register")
    public ResponseEntity<AdminClientDto>register(@RequestBody @Valid AdminSignUpDto adminClient) {
        AdminClientDto createdAdminClient = adminClientService.register(adminClient);
        createdAdminClient.setToken(adminClientAuthenticationProvider.createToken(createdAdminClient));
        return ResponseEntity.created(URI.create("/adminClients/" + createdAdminClient.getId())).body(createdAdminClient);
    }
}
