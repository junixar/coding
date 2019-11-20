package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    @Test
    void creatingPersonReturnsPerson(){
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
    void creatingPersonHasCorrectFirstName(){
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
    void creatingPersonHasCorrectLastName(){
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
    void creatingPersonWithEmptyFirstNameThrowsException(){
        // given
        String firstNameInput = "";
        String lastNameInput = "Hofmann";
        PersonService  personServ= new PersonService();

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            // when
            personServ.create(firstNameInput, lastNameInput);
        });
    }
}
