package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.AdminClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminClientRepository extends JpaRepository<AdminClient, Long> {

    Optional<AdminClient> findByLogin(String login); //find admin Client by Clientname

}