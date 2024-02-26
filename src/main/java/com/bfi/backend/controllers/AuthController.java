package com.bfi.backend.controllers;

import com.bfi.backend.config.UserAuthenticationProvider;
import com.bfi.backend.dtos.CredentialsDto;
import com.bfi.backend.dtos.SignUpDto;
import com.bfi.backend.dtos.UserDto;
import com.bfi.backend.entites.Phone;
import com.bfi.backend.services.PhoneService;
import com.bfi.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

   /* @PostMapping("/users/{userId}/phones")
    public ResponseEntity<Phone> addPhoneToUser(@PathVariable Long userId, @RequestBody Phone phone) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        // Assuming you have a method in PhoneService to add a phone to a user
        phone.setUser(UserDto);
        Phone savedPhone = phoneService.savePhone(phone);
        return ResponseEntity.ok(savedPhone);
    } */

    /*@PutMapping("/users/{userId}/phones/{phoneId}")
    public ResponseEntity<Phone> updatePhoneForUser(@PathVariable Long userId, @PathVariable Long phoneId, @RequestBody Phone newPhoneData) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        // Assuming you have a method in PhoneService to update a phone for a user
        Phone updatedPhone = phoneService.updatePhone(phoneId, newPhoneData);
        return ResponseEntity.ok(updatedPhone);
    } */

    /*@DeleteMapping("/users/{userId}/phones/{phoneId}")
    public ResponseEntity<Void> deletePhoneForUser(@PathVariable Long userId, @PathVariable Long phoneId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        // Assuming you have a method in PhoneService to delete a phone for a user
        phoneService.deletePhone(phoneId);
        return ResponseEntity.noContent().build();
    } */

}
