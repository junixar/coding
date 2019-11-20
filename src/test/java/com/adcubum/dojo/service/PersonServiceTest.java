package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    @Test
    void returnsAPerson(){
        // given
        String firstNameInput = "Zeljko";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService();
        Person person = personServ.create(firstNameInput, lastNameInput);

        // then
        assertThat(person).isNotNull();
    }

    @Test
    void returnedPersonHasCorrectFirstName(){
        // given
        String firstNameInput = "Zeljko";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService();
        Person person = personServ.create(firstNameInput, lastNameInput);

        // then
        assertThat(person.getFirstName()).isEqualTo(firstNameInput);
    }


    @Test
    void returnedPersonHasCorrectLastName(){
        // given
        String firstNameInput = "Zeljko";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService();
        Person person = personServ.create(firstNameInput, lastNameInput);

        // then
        assertThat(person.getLastName()).isEqualTo(lastNameInput);
    }


    @Test
    void returnedPersonHasCorrectLastName(){
        // given
        String firstNameInput = "";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService();
        assertThrows(IllegalArgumentException.class, () -> {
            personServ.create(firstNameInput, lastNameInput);
        });
    }
}
