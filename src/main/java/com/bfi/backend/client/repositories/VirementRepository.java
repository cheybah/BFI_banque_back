package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.OperationBancaire;
import com.bfi.backend.client.entites.TransfertRapide;
import com.bfi.backend.client.entites.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VirementRepository extends JpaRepository<Virement, Long> {
    List<Virement> findByCompteADebiteOrCompteACrediter(String compteADebite, String compteACrediter);

}
