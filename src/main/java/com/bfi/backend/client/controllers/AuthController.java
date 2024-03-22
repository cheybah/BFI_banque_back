package com.bfi.backend.client.controllers;

import com.bfi.backend.client.dtos.CredentialsDto;
import com.bfi.backend.client.auth.UserAuthenticationProvider;
import com.bfi.backend.client.dtos.SignUpDto;
import com.bfi.backend.client.dtos.UserDto;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.repositories.UserRepository;
import com.bfi.backend.client.services.UserService;
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

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final UserRepository userRepository;


    @PostMapping("/bfi/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/dash/informations-personelles")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        System.out.println("Created User: " + createdUser); // Add this line to print the created user
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
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Hibernate.initialize(user.getAddress()); // Explicitly initialize the address
            return ResponseEntity.ok(user); // Wrap the user in ResponseEntity and return
        } else {
            throw new AppException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmailExistence(@RequestParam String email) {
        boolean exists = userService.checkEmailExistence(email);
        return ResponseEntity.ok(Collections.singletonMap("exists", exists));
    }


}
