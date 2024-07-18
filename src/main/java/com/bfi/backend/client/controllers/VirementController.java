package com.bfi.backend.client.controllers;

import com.bfi.backend.client.dtos.VirementDto;
import com.bfi.backend.client.entites.Virement;
import com.bfi.backend.client.services.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VirementController {

    @Autowired
    private VirementService virementService;

    @GetMapping("virements")
    public ResponseEntity<List<Virement>> getAllVirements() {
        List<Virement> virements = virementService.getAllVirements();
        return ResponseEntity.ok(virements);
    }

    @PostMapping("virements")
    public ResponseEntity<Virement> createVirement(@RequestBody VirementDto request) {
        Virement virement = virementService.createVirement(
                request.getClientId(),
                request.getCompteADebiter(),
                request.getCompteACrediter(),
                request.getMontant(),
                request.getMotif()
        );
        return ResponseEntity.ok(virement);
    }

    @GetMapping("/byAccount")
    public ResponseEntity<List<Virement>> getVirementsByBankAccountRib(@RequestParam String rib) {
        List<Virement> virements = virementService.getVirementsByBankAccountRib(rib);
        return ResponseEntity.ok(virements);
    }
}
