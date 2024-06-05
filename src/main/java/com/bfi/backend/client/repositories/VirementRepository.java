package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.OperationBancaire;
import com.bfi.backend.client.entites.TransfertRapide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepository extends JpaRepository<TransfertRapide, Long> {
}
