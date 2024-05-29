package com.bfi.backend.admin.controllers;

import com.bfi.backend.admin.services.AdminClientService;
import com.bfi.backend.client.entites.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/archived-Clients")
public class ArchivedClientController {

    @Autowired
    private AdminClientService adminClientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllArchivedClients() {
        List<Client> archivedClients = adminClientService.getAllArchivedClients();
        return ResponseEntity.ok(archivedClients);
    }
}