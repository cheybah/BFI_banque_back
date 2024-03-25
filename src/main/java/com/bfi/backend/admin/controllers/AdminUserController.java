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

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adminUsers")
public class AdminUserController {

    @Autowired
    private AdminUserService adminuserService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminuserService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        try {
            adminuserService.deleteUser(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "User with ID " + id + " deleted successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Failed to delete user with ID " + id + "."));
        }
    }


}
