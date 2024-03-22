package com.bfi.backend.admin.services;

import com.bfi.backend.admin.entities.AdminUser;
import com.bfi.backend.admin.repository.AdminRepository;
import com.bfi.backend.client.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository; // Assuming you have a repository
    public List<AdminUser> getAdmin() {
        return adminRepository.findAll();
    }


}