package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {
    // Define custom query methods if needed
}