package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.User;
import com.bfi.backend.client.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login); //find user by login

    Optional<User> findByEmail(String email);
    List<User> findByStatus(UserStatus status);

}
