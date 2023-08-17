package com.registration.registrationpeople.controllers;

import com.registration.registrationpeople.domain.model.CreatePersonDTO;
import com.registration.registrationpeople.dto.PersonDTO;
import com.registration.registrationpeople.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/person")
    public ResponseEntity<?> newPerson(@RequestBody CreatePersonDTO personDTO) {
        var result = this.personService.addPerson(personDTO);

        if (result.isSuccess()) {
            return ResponseEntity.created(null).body(null);
        }

        var error = result.error();

        return ResponseEntity.status(error.getStatus()).body(error.format());
    }


    @GetMapping("/person")
    public ResponseEntity<List<PersonDTO>> getAll() {
        var result = this.personService.getAll();

        return ResponseEntity.ok(result);
    }
}
