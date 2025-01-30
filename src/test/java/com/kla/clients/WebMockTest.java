package com.kla.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kla.clients.controllers.ClientsController;
import com.kla.clients.dto.ClientDTO;
import com.kla.clients.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientsController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ClientService service;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        ClientDTO clientDTO = ClientDTO.builder().name("name").build();
        ResponseEntity<String> response = new ResponseEntity<>("Клиент успешно добавлен", HttpStatus.OK);
        when(service.addClient(clientDTO)).thenReturn(response);
        String json = objectMapper.writeValueAsString(clientDTO);
        this.mockMvc.perform(post("/clients/add").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Клиент успешно добавлен")));
    }
}
