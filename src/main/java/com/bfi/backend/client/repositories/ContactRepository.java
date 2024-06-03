package com.bfi.backend.client.repositories;


import com.bfi.backend.client.entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long aLong);
    List<Contact> findByClients_Id(Long clientId);
}
