package com.bfi.backend.client.controllers;


import com.bfi.backend.client.entites.Counter;
import com.bfi.backend.client.repositories.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    private CounterRepository counterRepository;

    @GetMapping
    public Map<String, Object> getCounterData() {
        Map<String, Object> counterData = new HashMap<>();

        // Récupérer la première ligne de la table Counter
        Optional<Counter> counterOptional = counterRepository.findById(1L);
        if (counterOptional.isPresent()) {
            Counter counter = counterOptional.get();
            counterData.put("projects", counter.getProject());
            counterData.put("loans", counter.getLoans());
            counterData.put("interest_rates", counter.getInterestRates());
            counterData.put("satisfied_customers", counter.getSatisfiedCustomers());
        }

        return counterData;
    }
}