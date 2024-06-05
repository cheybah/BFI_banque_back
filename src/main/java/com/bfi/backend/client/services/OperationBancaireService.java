package com.bfi.backend.client.services;


import com.bfi.backend.client.entites.OperationBancaire;
import com.bfi.backend.client.repositories.OperationBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationBancaireService {

    @Autowired
    private OperationBancaireRepository operationBancaireRepository;

    public List<OperationBancaire> getAllOperations() {
        return operationBancaireRepository.findAll();
    }

    public Optional<OperationBancaire> getOperationById(Long id) {
        return operationBancaireRepository.findById(id);
    }

    public OperationBancaire createOperation(OperationBancaire operation) {
        return operationBancaireRepository.save(operation);
    }

    public OperationBancaire updateOperation(Long id, OperationBancaire operationDetails) {
        return operationBancaireRepository.findById(id)
                .map(operation -> {
                    operation.setDate(operationDetails.getDate());
                    operation.setMantant(operationDetails.getMantant());
                    operation.setMotif(operationDetails.getMotif());
                    return operationBancaireRepository.save(operation);
                }).orElseThrow(() -> new RuntimeException("Operation not found"));
    }

    public void deleteOperation(Long id) {
        operationBancaireRepository.deleteById(id);
    }
}