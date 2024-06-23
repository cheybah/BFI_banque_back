package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {
    // Vous pouvez ajouter des méthodes supplémentaires ici si nécessaire
}