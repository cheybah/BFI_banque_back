package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.Rendez_Vous;
import com.bfi.backend.client.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public Rendez_Vous createRendezVous(Rendez_Vous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public List<Rendez_Vous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }
}
