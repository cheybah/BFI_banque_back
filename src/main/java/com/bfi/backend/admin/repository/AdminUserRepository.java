package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    Optional<AdminUser> findByLogin(String login); //find admin user by username

}