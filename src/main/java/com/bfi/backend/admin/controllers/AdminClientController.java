package com.bfi.backend.admin.controllers;


import com.bfi.backend.admin.services.AdminClientService;
import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/adminClients")
public class AdminClientController {

    @Autowired
    private AdminClientService adminClientService;
    @Autowired
    private ClientRepository ClientRepository;
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> Clients = adminClientService.getAllClients();
        return ResponseEntity.ok(Clients);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteClient(@PathVariable Long id) {
        try {
            adminClientService.deleteClient(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client with ID " + id + " deleted successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Failed to delete Client with ID " + id + "."));
        }
    }


}
