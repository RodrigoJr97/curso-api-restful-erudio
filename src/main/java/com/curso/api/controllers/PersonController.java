package com.curso.api.controllers;

import com.curso.api.model.Person;
import com.curso.api.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PersonController {

    @Autowired
    private PersonServices service;


    // @RequestMapping(value = "/{id},
    // method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @GetMapping()
    public List<Person> findAll() throws Exception{
        return service.findAll();
    }

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
