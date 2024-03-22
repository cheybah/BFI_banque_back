package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    // You can define additional methods here if needed
}

