package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.PersonneMorale;
import com.bfi.backend.client.repositories.PersonneMoraleRepository;
import com.bfi.backend.common.exceptions.AppException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/personne-morale")
public class PersonneMoraleController {

    @Autowired
    private PersonneMoraleRepository personneMoraleRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PersonneMorale> findById(@PathVariable("id") Long id) {
        Optional<PersonneMorale> optionalPersonneMorale = personneMoraleRepository.findById(id);
        if (optionalPersonneMorale.isPresent()) {
            PersonneMorale personneMorale = optionalPersonneMorale.get();
            Hibernate.initialize(personneMorale.getAddress()); // Explicitly initialize the address if necessary
            return ResponseEntity.ok(personneMorale); // Wrap the PersonneMorale in ResponseEntity and return
        } else {
            throw new AppException("Client not found", HttpStatus.NOT_FOUND);
        }
    }

    // Add other CRUD methods here if needed
}
