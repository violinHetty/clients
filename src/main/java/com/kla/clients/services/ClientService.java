package com.kla.clients.services;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;
import com.kla.clients.exception.ClientNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    ResponseEntity<String> addClient(ClientDTO client);

    ResponseEntity<String> addContact(Long id, Contact contact) throws ClientNotFoundException;

    ResponseEntity<List<Client>> getClients() throws ClientNotFoundException;

    ResponseEntity<ClientDTO> getClientById(Long id) throws ClientNotFoundException;

    ResponseEntity<List<Contact>> getContactsByClientId(Long id) throws ClientNotFoundException;

    ResponseEntity<List<Contact>> getContactsByType(Long idClient, String type) throws ClientNotFoundException;

}
