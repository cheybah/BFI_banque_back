package com.bfi.backend.repositories;

import com.bfi.backend.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}