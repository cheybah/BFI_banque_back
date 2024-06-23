package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.Depot;
import com.bfi.backend.client.entites.MakeDepositRequest;
import com.bfi.backend.client.services.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
