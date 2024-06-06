package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.ReclamationDto;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.entites.Reclamation;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.client.repositories.ReclamationRepository;
import com.bfi.backend.common.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamationService {

    private final ClientRepository clientRepository;
    private final ReclamationRepository reclamationRepository;

    @Autowired
    public ReclamationService(ClientRepository clientRepository, ReclamationRepository reclamationRepository) {
        this.clientRepository = clientRepository;
        this.reclamationRepository = reclamationRepository;
    }

    public Reclamation createReclamation(ReclamationDto reclamationDto) {
        // Find the client by ID
        Client client = clientRepository.findById(reclamationDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Create a new Reclamation object and set its fields from the DTO and the client
        Reclamation reclamation = new Reclamation();
        reclamation.setReference(reclamationDto.getReference());
        reclamation.setSujet(reclamationDto.getSujet());
        reclamation.setDate(reclamationDto.getDate());
        reclamation.setContenu(reclamationDto.getContenu());
        reclamation.setReponse(reclamationDto.getReponse());
        reclamation.setStatus(reclamationDto.getStatus());
        reclamation.setClient(client);

        // Save the entity
        return reclamationRepository.save(reclamation);
    }

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation getReclamationById(Long id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    public List<ReclamationDto> getAllReclamationsWithClientDetails() {
        return reclamationRepository.findAll().stream()
                .map(reclamation -> {
                    ReclamationDto reclamationDto = new ReclamationDto();
                    reclamationDto.setIdReclamation(reclamation.getIdReclamation()); // Add this line
                    reclamationDto.setClientId(reclamation.getClient().getId());
                    reclamationDto.setReference(reclamation.getReference());
                    reclamationDto.setSujet(reclamation.getSujet());
                    reclamationDto.setContenu(reclamation.getContenu());
                    reclamationDto.setDate(reclamation.getDate());
                    reclamationDto.setReponse(reclamation.getReponse());
                    reclamationDto.setStatus(reclamation.getStatus());
                    return reclamationDto;
                })
                .collect(Collectors.toList());
    }


    public Reclamation updateReclamation(Long id, Reclamation reclamationDetails) {
        Reclamation reclamation = reclamationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation not found with id: " + id));
        reclamation.setReponse(reclamationDetails.getReponse());
        reclamation.setStatus(reclamationDetails.getStatus());
        Reclamation updatedReclamation = reclamationRepository.save(reclamation);
        return updatedReclamation;
    }


    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }
}
