package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.OperationBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationBancaireRepository extends JpaRepository<OperationBancaire, Long> {
}
