package com.bfi.backend.client.controllers;

import com.bfi.backend.client.dtos.ReclamationDto;
import com.bfi.backend.client.entites.Reclamation;
import com.bfi.backend.client.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-client/reclamations")
public class ReclamationController {


    @Autowired
    private ReclamationService reclamationService;

    @PostMapping
    public ResponseEntity<Reclamation> createReclamation(@RequestBody ReclamationDto reclamationDto) {
        Reclamation savedReclamation = reclamationService.createReclamation(reclamationDto);
        return new ResponseEntity<>(savedReclamation, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @GetMapping("/{id}")
    public Reclamation getReclamationById(@PathVariable Long id) {
        return reclamationService.getReclamationById(id);
    }

    @PutMapping("/{id}")
    public Reclamation updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamationDetails) {
        return reclamationService.updateReclamation(id, reclamationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
    }
}
