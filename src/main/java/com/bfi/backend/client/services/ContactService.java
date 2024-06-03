package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.Contact;
import com.bfi.backend.client.entites.Phone;
import com.bfi.backend.client.repositories.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllByClientId(Long clientId) {
        // Ajoutez votre logique ici pour récupérer les contacts par clientId
        return contactRepository.findByClients_Id(clientId);
    }
}
