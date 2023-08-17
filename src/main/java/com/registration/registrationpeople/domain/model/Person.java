package com.registration.registrationpeople.domain.model;

import com.registration.registrationpeople.core.DocumentUtils;
import com.registration.registrationpeople.core.Result;
import com.registration.registrationpeople.core.SimpleError;
import com.registration.registrationpeople.domain.enums.TypeDocument;
import com.registration.registrationpeople.dto.PersonDTO;
import org.springframework.http.HttpStatus;

public class Person {
    private final String name;
    private final String document;
    private final TypeDocument typeDocument;


    private Person(String name, String document, TypeDocument typeDocument) {
        this.name = name;
        this.document = document;
        this.typeDocument = typeDocument;
    }

    public static Result<Person, SimpleError> create(String name, String document) {
        if (name == null || name.isBlank()) {
            return Result.failure(new SimpleError("Você deve informar um nome", HttpStatus.BAD_REQUEST));
        }

        if (document == null || document.isBlank()) {
            return Result.failure(new SimpleError("Você deve informar o documento", HttpStatus.BAD_REQUEST));
        }

        if (DocumentUtils.isCPF(document) == false && DocumentUtils.isCNPJ(document) == false) {
            return Result.failure(new SimpleError("Você deve informar um documento valido", HttpStatus.BAD_REQUEST));
        }

        var typeDocument = DocumentUtils.isCPF(document) ? TypeDocument.CPF : TypeDocument.CNPJ;

        return Result.ok(new Person(name, document, typeDocument));
    }


    public PersonDTO format() {
        return new PersonDTO(this.name, this.document, this.typeDocument.getValue());
    }
}
