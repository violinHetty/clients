package com.kla.clients.services;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Contact;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<String> addClient(ClientDTO client);

    ResponseEntity<String> addContact(Long id, Contact contact);

}
