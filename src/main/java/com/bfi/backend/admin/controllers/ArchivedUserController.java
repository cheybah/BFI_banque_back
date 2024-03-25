package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.services.AdminUserService;
import com.bfi.backend.client.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/archived-users")
public class ArchivedUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping
    public ResponseEntity<List<User>> getAllArchivedUsers() {
        List<User> archivedUsers = adminUserService.getAllArchivedUsers();
        return ResponseEntity.ok(archivedUsers);
    }
}