package com.curso.api.services;

import com.curso.api.exceptions.ResourceNotFoundException;
import com.curso.api.model.Person;
import com.curso.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Buscando todas as pessoas");

        return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Buscando uma pessoa");

        return repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public Person create(Person person) {
        logger.info("Pessoa criada");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update pessoa");

        Person entity = repository.findById(person.getId())
                .orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrado"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Delete pessoa");

        Person entity = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Cliente não encontrado"));

        repository.deleteById(id);
    }


}
