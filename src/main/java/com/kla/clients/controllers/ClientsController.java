package com.kla.clients.controllers;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Contact;
import com.kla.clients.exception.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kla.clients.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientsController {

    private final ClientService service;

    @PostMapping("/add")
    public ResponseEntity<String> addClient(@RequestBody ClientDTO client) {
        return service.addClient(client);
    }

    @PostMapping("/addContact/{idClient}")
    public ResponseEntity<String> addClient(@PathVariable Long idClient, @RequestBody Contact contact) throws ClientNotFoundException {
        return service.addContact(idClient, contact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) throws ClientNotFoundException {
        return service.getClientById(id);
    }

    @GetMapping("/getContacts/{idClient}")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable Long idClient) throws ClientNotFoundException {
        return service.getContactsByClientId(idClient);
    }

    @GetMapping("/getContactsByType/{idClient}")
    public ResponseEntity<List<Contact>> getContactsByType(@PathVariable Long idClient, @RequestParam String type) throws ClientNotFoundException {
        return service.getContactsByType(idClient, type);
    }
}
