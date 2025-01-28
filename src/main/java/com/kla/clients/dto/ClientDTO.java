package com.kla.clients.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class ClientDTO {

    private Long id;
    private String name;
    private List<ContactDTO> contacts;
}
