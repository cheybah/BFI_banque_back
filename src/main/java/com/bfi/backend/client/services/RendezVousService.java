package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.RendezVousDto;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.entites.Rendez_Vous;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.client.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Rendez_Vous createRendezVous(RendezVousDto rendezVousDto) {
        // Find the client by ID
        Client client = clientRepository.findById(rendezVousDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Create a new Rendez_Vous object and set its fields from the DTO and the client
        Rendez_Vous rendezVous = new Rendez_Vous();
        rendezVous.setAgence(rendezVousDto.getAgence());
        rendezVous.setRaison(rendezVousDto.getRaison());
        rendezVous.setDate(rendezVousDto.getDate());
        rendezVous.setHeure(rendezVousDto.getHeure());
        rendezVous.setStatus(rendezVousDto.getStatus());
        rendezVous.setClient(client);

        // Save the entity
        return rendezVousRepository.save(rendezVous);
    }

    public List<Rendez_Vous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    public List<RendezVousDto> getAllRendezVousWithClientDetails() {
        return rendezVousRepository.findAll().stream()
                .map(rendezVous -> {
                    RendezVousDto rendezVousDto = new RendezVousDto();
                    rendezVousDto.setId(rendezVous.getId()); // Add this line
                    rendezVousDto.setClientId(rendezVous.getClient().getId());
                    rendezVousDto.setAgence(rendezVous.getAgence());
                    rendezVousDto.setRaison(rendezVous.getRaison());
                    rendezVousDto.setDate(rendezVous.getDate());
                    rendezVousDto.setHeure(rendezVous.getHeure());
                    rendezVousDto.setStatus(rendezVous.getStatus());
                    return rendezVousDto;
                })
                .collect(Collectors.toList());
    }

    public Rendez_Vous updateRendezVousStatus(Long id, String status) {
        Rendez_Vous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendez_Vous not found"));
        rendezVous.setStatus(status);
        return rendezVousRepository.save(rendezVous);
    }
}
