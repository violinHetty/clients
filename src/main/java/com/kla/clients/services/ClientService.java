package com.kla.clients.services;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;
import com.kla.clients.enums.ContactType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientService {

    ResponseEntity<String> addClient(ClientDTO client);

    ResponseEntity<String> addContact(Long id, Contact contact);

    ResponseEntity<List<Client>> getClients();

    ResponseEntity<ClientDTO> getClientById(Long id);

    ResponseEntity<List<Contact>> getContactsByClientId(Long id);

    ResponseEntity<List<Contact>> getContactsByType(Long idClient, String type);

}
