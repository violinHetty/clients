package com.kla.clients.dto;

import com.kla.clients.enums.ContactType;
import lombok.Data;

@Data
public class ContactDTO {

    private Long id;

    private String value; // значение телефона или email-а
    private ContactType type;  // "PHONE" или "EMAIL"
}
