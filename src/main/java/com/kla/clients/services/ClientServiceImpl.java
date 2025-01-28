package com.kla.clients.services;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;
import com.kla.clients.repositories.ClientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

  private final  ClientsRepository repository;
    @Override
    public ResponseEntity<String> addClient(ClientDTO client) {
        try {
            repository.save(mapToEntity(client));
            return new ResponseEntity<>("Клиент успешно добавлен", HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            return new ResponseEntity<>("Ошибка при добавлении клиента", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> addContact(Long id, Contact contact) {

        try {
            Client client= repository.findById(id).orElseThrow();
            List <Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            client.setContacts(contacts);
            repository.save(client);
            return new ResponseEntity<>("Контакт успешно добавлен", HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            return new ResponseEntity<>("Ошибка при добавлении контакта", HttpStatus.INTERNAL_SERVER_ERROR);
        }    }

    private Client mapToEntity(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .build();
    }
}
