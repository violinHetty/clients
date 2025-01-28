package com.kla.clients.enums;

import lombok.Getter;

@Getter
public enum ContactType {
    PHONE("phone"),
    EMAIL("email");

    private String value;

    ContactType(String value) {
    }
}
