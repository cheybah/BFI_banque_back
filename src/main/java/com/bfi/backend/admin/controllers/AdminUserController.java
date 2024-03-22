package com.bfi.backend.admin.controllers;


import com.bfi.backend.admin.services.AdminUserService;
import com.bfi.backend.client.dtos.UserDto;
import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.mappers.UserMapper;
import com.bfi.backend.client.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adminUsers")
public class AdminUserController {

    @Autowired
    private AdminUserService adminuserService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminuserService.getAllUsers();
        return ResponseEntity.ok(users);
    }
@Autowired
private UserRepository userRepository;
@Autowired

private  UserMapper userMapper;

  /*  @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream()
                .map(user -> {
                    UserDto userDto = userMapper.toUserDto(user);
                    byte[] photoBytes = user.getPhoto().getBytes(); // Obtenez les données binaires de l'image
                    String base64EncodedPhoto = Base64.getEncoder().encodeToString(photoBytes); // Convertissez en base64
                    userDto.setPhoto(Arrays.toString(base64EncodedPhoto.getBytes())); // Assignez la chaîne base64 à UserDto
                    return userDto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            adminuserService.deleteUser(id);
            return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete user with ID " + id + ".");
        }
    }
}
