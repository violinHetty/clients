package com.kla.clients.mappers;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.dto.ContactDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;

import java.util.List;

public class ClientMapper {
    public static Client mapToEntity(ClientDTO clientDTO) {
        List<ContactDTO> contacts = clientDTO.getContacts();
        List<Contact> contactList = null;
        if (contacts != null) {
            contactList = contacts.stream().map(ContactMapper::mapToEntity).toList();
        }
        return Client.builder()
                .name(clientDTO.getName())
                .contacts(contactList)
                .build();
    }

    public static ClientDTO mapToDTO(Client client) {
        List<Contact> contacts = client.getContacts();
        List<ContactDTO> contactList =null;
        if (contacts != null) {
            contactList = contacts.stream().map(ContactMapper::mapToDTO).toList();
        }
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .contacts(contactList)
                .build();
    }
}
