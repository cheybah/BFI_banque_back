package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
