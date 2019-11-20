package com.adcubum.dojo.service;

import com.adcubum.dojo.domain.Person;

import com.adcubum.dojo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    PersonRepository repositoryMock;

    @BeforeEach
    void setup() {
        this.repositoryMock = Mockito.mock(PersonRepository.class);
    }

    @Test
    void creatingPersonReturnsPerson(){
        // given
        String firstNameInput = "Zeljko";
        String lastNameInput = "Hofmann";

        // when
        PersonService  personServ= new PersonService(repositoryMock);
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
        PersonService  personServ= new PersonService(repositoryMock);
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
        PersonService  personServ= new PersonService(repositoryMock);
        Person person = personServ.create(firstNameInput, lastNameInput);

        // then
        assertThat(person.getLastName()).isEqualTo(lastNameInput);
    }


    @Test
    void creatingPersonWithEmptyFirstNameThrowsException(){
        // given
        String firstNameInput = "";
        String lastNameInput = "Hofmann";
        PersonService  personServ= new PersonService(repositoryMock);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            // when
            personServ.create(firstNameInput, lastNameInput);
        });
    }

    @Test
    void creatingPersonWithEmptyLastNameThrowsException(){
        // given
        String firstNameInput = "Zelko";
        String lastNameInput = "";
        PersonService  personServ= new PersonService(repositoryMock);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            // when
            personServ.create(firstNameInput, lastNameInput);
        });
    }

    @Test
    void creatingPersonWillInvokeRepositorySave(){
        // given
        String firstNameInput = "Zelko";
        String lastNameInput = "Hofmann";

        PersonService personServ= new PersonService(repositoryMock);

        // when
        personServ.create(firstNameInput, lastNameInput);

        // then
        Mockito.verify(repositoryMock).save(argument.capture());
    }

    @Test
    void creatingPersonWillInvokeRepositorySaveWithPersonDatabaseObject(){
        // given
        String firstNameInput = "Zelko";
        String lastNameInput = "Hofmann";

        PersonService personServ= new PersonService(repositoryMock);

        // when
        personServ.create(firstNameInput, lastNameInput);

        // then

        ArgumentCaptor<PersonEntity> argument = ArgumentCaptor.forClass(PersonEntity.class);
        Mockito.verify(repositoryMock).save(argument.capture());

    }
}
