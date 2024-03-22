package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.Archived_App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivedUserRepository extends JpaRepository<Archived_App_User, Long> {
    // You can define custom methods for querying archived users if needed
}