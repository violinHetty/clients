package com.kla.clients.services;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;
import com.kla.clients.exception.ClientNotFoundException;
import com.kla.clients.mappers.ClientMapper;
import com.kla.clients.repositories.ClientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.kla.clients.mappers.ClientMapper.mapToEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientsRepository repository;

    @Override
    public ResponseEntity<String> addClient(ClientDTO client) {
        Client entity = mapToEntity(client);
        repository.save(entity);
            return new ResponseEntity<>("Клиент успешно добавлен", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addContact(Long id, Contact contact) throws ClientNotFoundException {

            Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Ошибка при поиске клиента"));
            List<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            client.setContacts(contacts);
            repository.save(client);
            return new ResponseEntity<>("Контакт успешно добавлен", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>((List<Client>) repository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> getClientById(Long id) throws ClientNotFoundException {
        Client client = repository.findById(id).orElseThrow(() -> new ClientNotFoundException("Ошибка при поиске клиента"));
        return new ResponseEntity<>(ClientMapper.mapToDTO(client), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<Contact>> getContactsByClientId(Long idClient) throws ClientNotFoundException {
        Client client = repository.findById(idClient).orElseThrow(() -> new ClientNotFoundException("Ошибка при поиске клиента"));
        return new ResponseEntity<>(client.getContacts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Contact>> getContactsByType(Long idClient, String type) throws ClientNotFoundException {
            Client client = repository.findById(idClient).orElseThrow(() -> new ClientNotFoundException("Ошибка при поиске клиента"));
            List<Contact> contactList = client.getContacts().stream()
                    .filter(contact -> contact.getType().getValue().equals(type))
                    .toList();
            return new ResponseEntity<>(contactList, HttpStatus.OK);
    }


}
