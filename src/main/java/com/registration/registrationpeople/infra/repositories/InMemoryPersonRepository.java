package com.registration.registrationpeople.infra.repositories;

import com.registration.registrationpeople.domain.model.Person;
import com.registration.registrationpeople.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryPersonRepository {

    private final ArrayList<Person> people = new ArrayList<>();


    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<PersonDTO> getAll() {
        return this.people.stream().map(person -> person.format()).toList();
    }



}
