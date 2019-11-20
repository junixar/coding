package com.adcubum.dojo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    @Test
    void returnsAPerson(){

        // given
        String firstNameInput = "Zeljko";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService();
         personServ.create(firstNameInput, lastNameInput);

        // then


    }
}
