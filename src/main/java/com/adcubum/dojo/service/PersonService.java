package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;
import com.adcubum.dojo.repository.PersonRepository;

public class PersonService {

    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(String firstNameInput, String lastNameInput) {
        validateInputParameters(firstNameInput, lastNameInput);
        return new Person(firstNameInput, lastNameInput);
    }

    private void validateInputParameters(String firstNameInput, String lastNameInput) {
        if (firstNameInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (lastNameInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
