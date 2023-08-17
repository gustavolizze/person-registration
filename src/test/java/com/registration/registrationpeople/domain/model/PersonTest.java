package com.registration.registrationpeople.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void shouldReturnPersonWithCPF() {
        var peopleResult = Person.create("Gustavo", "884.421.880-10");

        Assertions.assertTrue(peopleResult.isSuccess());

        var people = peopleResult.get();

        Assertions.assertTrue(people instanceof Person);
    }

    @Test
    void shouldReturnPersonWithCNPJ() {
        var peopleResult = Person.create("Gustavo", "54.872.457/0001-15");

        Assertions.assertTrue(peopleResult.isSuccess());

        var people = peopleResult.get();

        Assertions.assertTrue(people instanceof Person);
    }

    @Test
    void notReturnPersonWithoutName() {
        var peopleResult = Person.create("", "54.872.457/0001-15");

        Assertions.assertFalse(peopleResult.isSuccess());
    }

    @Test
    void notReturnPersonWithoutDocument() {
        var peopleResult = Person.create("Gustavo", null);

        Assertions.assertFalse(peopleResult.isSuccess());
    }

    @Test
    void notReturnPersonWithCPFInvalid() {
        var peopleResult = Person.create("Gustavo", "11111111111");

        Assertions.assertFalse(peopleResult.isSuccess());
    }

    @Test
    void notReturnPersonWithCNPJInvalid() {
        var peopleResult = Person.create("Gustavo", "54.872.457/0002-16");

        Assertions.assertFalse(peopleResult.isSuccess());
    }

}
