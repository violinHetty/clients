package com.kla.clients.dto;

import com.kla.clients.enums.ContactType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ContactDTO {

    private Long id;

    private String value; // значение телефона или email-а
    private ContactType type;  // "PHONE" или "EMAIL"
}
