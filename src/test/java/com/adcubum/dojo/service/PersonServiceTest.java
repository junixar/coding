package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
