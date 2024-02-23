package com.bfi.backend.controllers;

import com.bfi.backend.config.UserAuthenticationProvider;
import com.bfi.backend.dtos.CredentialsDto;
import com.bfi.backend.dtos.SignUpDto;
import com.bfi.backend.dtos.UserDto;
import com.bfi.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/dash/informations-personelles")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    @PutMapping("/reset")
    public ResponseEntity<UserDto> resetPassword(@RequestBody Map<String, String> resetRequest) {
        String login = resetRequest.get("login");
        String newPassword = resetRequest.get("newpassword");

        // Call the resetPassword method of the UserService
        userService.resetPassword(login, newPassword);

        // Retrieve updated user details
        UserDto updatedUser = userService.findByLogin(login);

        // Regenerate token for the updated user
        String newToken = userAuthenticationProvider.createToken(updatedUser);
        updatedUser.setToken(newToken);

        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailExistence(@RequestParam String email) {
        boolean exists = userService.checkEmailExistence(email);
        return ResponseEntity.ok(Collections.singletonMap("exists", exists));
    }

}
