package com.bfi.backend.repositories;

import com.bfi.backend.entites.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
