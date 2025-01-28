package com.kla.clients.entities;

import com.kla.clients.enums.ContactType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value; // значение телефона или email-а
    private ContactType type;  // "PHONE" или "EMAIL"
}
