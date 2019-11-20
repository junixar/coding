package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;

public class PersonService {
    public Person create(String firstNameInput, String lastNameInput) {
        return new Person(firstNameInput, lastNameInput);
    }
}
