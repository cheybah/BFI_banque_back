package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.Depot;
import com.bfi.backend.client.entites.MakeDepositRequest;
import com.bfi.backend.client.services.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depot")
public class DepotController {

    @Autowired
    private DepotService depotService;

    @PostMapping("/makeDeposit")
    public ResponseEntity<Depot> makeDeposit(@RequestBody MakeDepositRequest request) {
        Depot depot = depotService.makeDeposit(request.getMontant(), request.getRibDepotCompteSource(), request.getDepotOption(), request.getMotif());
        return ResponseEntity.ok(depot);
    }
    @GetMapping("/allDepots")
    public ResponseEntity<List<Depot>> getAllDepots() {
        List<Depot> depots = depotService.getAllDepots();
        return ResponseEntity.ok(depots);
    }
    @PostMapping("/requestDeposit")
    public ResponseEntity<Depot> requestDeposit(@RequestBody MakeDepositRequest request) {
        Depot depot = depotService.requestDeposit(request.getMontant(), request.getRibDepotCompteSource(), request.getDepotOption(), request.getMotif());
        return ResponseEntity.ok(depot);
    }

    @PostMapping("/approveDeposit/{id}")
    public ResponseEntity<Depot> approveDeposit(@PathVariable Long id) {
        Depot depot = depotService.approveDeposit(id);
        return ResponseEntity.ok(depot);
    }
    @PostMapping("/reject/{id}")
    public ResponseEntity<Depot> rejectDeposit(@PathVariable Long id) {
        Depot depot = depotService.rejectDeposit(id);
        return ResponseEntity.ok(depot);
    }
}
