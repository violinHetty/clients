package com.kla.clients.mappers;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.dto.ContactDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.entities.Contact;

public class ContactMapper {
    public static Contact mapToEntity(ContactDTO contactDTO) {
        return Contact.builder()
                .value(contactDTO.getValue())
                .type(contactDTO.getType())
                .build();
    }

    public static ContactDTO mapToDTO(Contact contact) {
        return ContactDTO.builder()
                .value(contact.getValue())
                .type(contact.getType())
                .build();
    }

}
