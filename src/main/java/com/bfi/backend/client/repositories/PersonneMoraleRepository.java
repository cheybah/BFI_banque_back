package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.PersonneMorale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonneMoraleRepository extends JpaRepository<PersonneMorale, Long> {
    Optional<PersonneMorale> findById(Long aLong);

}
