package com.kla.clients.controllers;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kla.clients.services.ClientService;

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
    public ResponseEntity<String> addClient(@PathVariable Long idClient, @RequestBody Contact contact){
        return service.addContact(idClient, contact);
    }


}
