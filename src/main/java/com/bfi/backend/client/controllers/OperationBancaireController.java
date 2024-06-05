package com.bfi.backend.client.controllers;


import com.bfi.backend.client.entites.OperationBancaire;
import com.bfi.backend.client.services.OperationBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationBancaireController {

    @Autowired
    private OperationBancaireService operationBancaireService;

    @GetMapping
    public List<OperationBancaire> getAllOperations() {
        return operationBancaireService.getAllOperations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationBancaire> getOperationById(@PathVariable Long id) {
        return operationBancaireService.getOperationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public OperationBancaire createOperation(@RequestBody OperationBancaire operation) {
        return operationBancaireService.createOperation(operation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationBancaire> updateOperation(@PathVariable Long id, @RequestBody OperationBancaire operationDetails) {
        try {
            OperationBancaire updatedOperation = operationBancaireService.updateOperation(id, operationDetails);
            return ResponseEntity.ok(updatedOperation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        operationBancaireService.deleteOperation(id);
        return ResponseEntity.noContent().build();
    }
}