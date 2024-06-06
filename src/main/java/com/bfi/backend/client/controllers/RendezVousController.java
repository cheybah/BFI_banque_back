package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.Rendez_Vous;
import com.bfi.backend.client.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-client/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @PostMapping
    public Rendez_Vous createRendezVous(@RequestBody Rendez_Vous rendezVous) {
        return rendezVousService.createRendezVous(rendezVous);
    }

    @GetMapping
    public List<Rendez_Vous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }
}

