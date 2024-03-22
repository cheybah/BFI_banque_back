package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.entities.AdminUser;
import com.bfi.backend.admin.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<AdminUser>> getAdminUsers() {
        List<AdminUser> adminUsers = adminService.getAdmin();
        return new ResponseEntity<>(adminUsers, HttpStatus.OK);
    }
}