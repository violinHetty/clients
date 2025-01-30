package com.kla.clients.mappers;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;

public class ClientMapper {
    public static Client mapToEntity(ClientDTO clientDTO) {
        return Client.builder()
                .name(clientDTO.getName())
                .build();
    }

    public static ClientDTO mapToDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .build();
    }
}
