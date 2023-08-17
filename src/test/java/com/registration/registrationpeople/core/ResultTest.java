package com.registration.registrationpeople.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ResultTest {

    @Test
    void resultShouldBeSuccess() {
        var result = Result.ok(1);

        Assertions.assertTrue(result.isSuccess());
    }


    @Test
    void resultShouldBeError() {
        var result = Result.failure(new SimpleError("Error", HttpStatus.BAD_REQUEST));

        Assertions.assertFalse(result.isSuccess());
    }
}
