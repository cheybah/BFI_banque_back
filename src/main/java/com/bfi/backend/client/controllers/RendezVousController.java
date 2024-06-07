package com.bfi.backend.client.controllers;

import com.bfi.backend.client.dtos.RendezVousDto;
import com.bfi.backend.client.entites.Rendez_Vous;
import com.bfi.backend.client.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-client/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @PostMapping
    public ResponseEntity<Rendez_Vous> createRendezVous(@RequestBody RendezVousDto rendezVousDto) {
        Rendez_Vous savedRendezVous = rendezVousService.createRendezVous(rendezVousDto);
        return new ResponseEntity<>(savedRendezVous, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Rendez_Vous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/with-client-details")
    public List<RendezVousDto> getAllRendezVousWithClientDetails() {
        return rendezVousService.getAllRendezVousWithClientDetails();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Rendez_Vous> updateRendezVousStatus(@PathVariable Long id, @RequestBody String status) {
        status = status.trim();
        Rendez_Vous updatedRendezVous = rendezVousService.updateRendezVousStatus(id, status);
        return new ResponseEntity<>(updatedRendezVous, HttpStatus.OK);
    }
}

