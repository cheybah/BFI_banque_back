package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByLogin(String login); //find Client by login
    Optional<Client> findByEmail(String email);
    List<Client> findByStatus(boolean status);
    Optional<Client> findById(Long aLong);


}
