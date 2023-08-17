package com.registration.registrationpeople.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class SimpleErrorTest {
    @Test
    void shouldBeInstanciate() {
        Assertions.assertDoesNotThrow(() -> new SimpleError("Error", HttpStatus.BAD_REQUEST));
    }

    @Test
    void shouldBeReturnsDTOFromFormatMethod() {
        var error = new SimpleError("Error", HttpStatus.BAD_REQUEST);
        var format = error.format();

        Assertions.assertTrue(format instanceof SimpleErrorDTO);
        Assertions.assertEquals("Error", format.getMessage());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, format.getStatus());
    }
}
