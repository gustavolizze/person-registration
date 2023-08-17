package com.registration.registrationpeople.domain.enums;

public enum TypeDocument {
    CPF("CPF"),
    CNPJ("CNPJ");

    private String value;

    TypeDocument(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
