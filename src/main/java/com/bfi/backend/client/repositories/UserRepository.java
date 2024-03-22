package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login); //find user by login

    Optional<User> findByEmail(String email);


    Optional<User> findById(Long aLong);
}
