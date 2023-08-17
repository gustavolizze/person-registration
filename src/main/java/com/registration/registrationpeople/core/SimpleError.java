package com.registration.registrationpeople.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SimpleError extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public SimpleError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public SimpleErrorDTO format() {
        return new SimpleErrorDTO(this.message, this.status);
    }
}
