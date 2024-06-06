package com.bfi.backend.client.repositories;

import com.bfi.backend.client.entites.Rendez_Vous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<Rendez_Vous, Long> {
}
