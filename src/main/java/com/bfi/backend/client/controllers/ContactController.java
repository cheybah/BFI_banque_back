package com.bfi.backend.client.controllers;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.entites.Contact;
import com.bfi.backend.client.repositories.ContactRepository;

import com.bfi.backend.client.services.ContactService;
import com.bfi.backend.common.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor

@RestController
public class ContactController {

    private final ContactRepository contactRepository;
    private final ContactService contactService;


    @GetMapping("contacts/{id}")
    public Optional<Contact> getContactById(@PathVariable Long id) {

        return contactRepository.findById(id);
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact) {
        if (contact.getFullName() == null || contact.getFullName().isEmpty()) {
            new AppException("Full name is required.", HttpStatus.NO_CONTENT);
        }
        return contactService.addContact(contact);
    }
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/clients/{clientId}/contacts")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable Long clientId) {
        List<Contact> contacts = contactService.getAllByClientId(clientId);
        return ResponseEntity.ok(contacts);
    }
}
