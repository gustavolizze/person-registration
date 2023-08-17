package com.registration.registrationpeople.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class SimpleErrorDTO {
    private final String message;
    private final HttpStatus status;
}
