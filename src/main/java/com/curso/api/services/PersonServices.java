package com.curso.api.services;

import com.curso.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Buscando todas as pessoas");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }


    public Person findById(String id) {
        logger.info("Buscando uma pessoa");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Steve");
        person.setLastName("Rogers");
        person.setAdress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Pessoa criada");

        return person;
    }

    public Person update(Person person) {
        logger.info("Update pessoa");

        return person;
    }

    public void delete(String id) {
        logger.info("Delete pessoa");
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAdress("Some adress in Brasil " + i);
        person.setGender("Male");

        return person;
    }

}
