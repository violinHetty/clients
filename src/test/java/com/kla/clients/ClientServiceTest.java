package com.kla.clients;

import com.kla.clients.dto.ClientDTO;
import com.kla.clients.entities.Client;
import com.kla.clients.mappers.ClientMapper;
import com.kla.clients.repositories.ClientsRepository;
import com.kla.clients.services.ClientService;
import com.kla.clients.services.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes =
        {ClientServiceImpl.class})
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;
    @MockitoBean
    private ClientsRepository clientsRepository;



    @Test
    void addClientTest() {
        ClientDTO clientDTO =
                ClientDTO.builder()
                        .name("name").build();
        clientService.addClient(clientDTO);
        Client entity = ClientMapper.mapToEntity(clientDTO);
        verify(clientsRepository, only()).save(entity);
    }
}
