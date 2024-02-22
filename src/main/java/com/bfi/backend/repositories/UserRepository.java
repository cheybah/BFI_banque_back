package com.bfi.backend.repositories;

import com.bfi.backend.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login); //find user by login
    Optional<User> findByEmail(String email); //find user by email
    Optional<User> findByPhoneNumber(String phoneNumber); //find user by phone number
}