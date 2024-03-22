package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.admin.services.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class AgencyController {
    @Autowired
    private AgencyService agencyService;
    @GetMapping("/agencies")
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> agencies = agencyService.getAllAgencies();
        return new ResponseEntity<>(agencies, HttpStatus.OK);
    }


    @PostMapping("/addAgency")
    public ResponseEntity<Agency> addAgency(@RequestBody Agency agency) {
        Agency addedAgency = agencyService.addAgency(agency);
        return new ResponseEntity<>(addedAgency, HttpStatus.CREATED);
    }

    @GetMapping("/agencies/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable Long id) {
        Agency agency = agencyService.getAgencyById(id);
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }
    @DeleteMapping("/agencies/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/agencies/{id}")
    public ResponseEntity<Agency> updateAgency(@PathVariable Long id, @RequestBody Agency updatedAgencyData) {
        Agency updatedAgency = agencyService.updateAgency(id, updatedAgencyData);
        return new ResponseEntity<>(updatedAgency, HttpStatus.OK);
    }
}