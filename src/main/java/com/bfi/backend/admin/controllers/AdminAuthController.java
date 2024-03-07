package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.auth.AdminUserAuthenticationProvider;
import com.bfi.backend.admin.dtos.AdminSignUpDto;
import com.bfi.backend.admin.dtos.AdminUserDto;
import com.bfi.backend.admin.services.AdminUserService;
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

    private final AdminUserService adminUserService;
    private final AdminUserAuthenticationProvider adminUserAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<AdminUserDto> login(@RequestBody @Valid AdminCredentialsDto admincredentialsDto) {
        AdminUserDto adminUserDto = adminUserService.login(admincredentialsDto);
        adminUserDto.setToken(adminUserAuthenticationProvider.createToken(adminUserDto));
        return ResponseEntity.ok(adminUserDto);
    }

    @PostMapping("/register")
    public ResponseEntity<AdminUserDto>register(@RequestBody @Valid AdminSignUpDto adminUser) {
        AdminUserDto createdAdminUser = adminUserService.register(adminUser);
        createdAdminUser.setToken(adminUserAuthenticationProvider.createToken(createdAdminUser));
        return ResponseEntity.created(URI.create("/adminUsers/" + createdAdminUser.getId())).body(createdAdminUser);
    }
}
