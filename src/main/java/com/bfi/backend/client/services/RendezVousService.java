package com.bfi.backend.client.services;

import com.bfi.backend.client.dtos.RendezVousDto;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.entites.Rendez_Vous;
import com.bfi.backend.client.repositories.ClientRepository;
import com.bfi.backend.client.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
