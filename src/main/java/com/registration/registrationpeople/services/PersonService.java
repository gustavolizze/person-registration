package com.registration.registrationpeople.services;

import com.registration.registrationpeople.core.Result;
import com.registration.registrationpeople.core.SimpleError;
import com.registration.registrationpeople.domain.model.CreatePersonDTO;
import com.registration.registrationpeople.domain.model.Person;
import com.registration.registrationpeople.dto.PersonDTO;
import com.registration.registrationpeople.infra.repositories.InMemoryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final InMemoryPersonRepository personRepository;

    @Autowired
    public PersonService(InMemoryPersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Result<Void, SimpleError> addPerson(CreatePersonDTO personDTO) {
        var personResult = Person.create(personDTO.getName(), personDTO.getDocument());

        if (personResult.isSuccess()) {
            this.personRepository.addPerson(personResult.get());
            return Result.ok(null);
        }
        else {
            return Result.failure(personResult.error());
        }
    }

    public List<PersonDTO> getAll() {
        return this.personRepository.getAll();
    }
}
