package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;

public class PersonService {
    public Person create(String firstNameInput, String lastNameInput) {
        Person p = new Person();
        p.setFirstName(firstNameInput);
        p.setLastName(lastNameInput);
        return p;
    }
}
