package com.curso.api.controllers;

import com.curso.api.model.Person;
import com.curso.api.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PersonController {

    @Autowired
    private PersonServices service;


    // @RequestMapping(value = "/{id},
    // method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) throws Exception{
        return service.findById(id);
    }

    @GetMapping("/")
    public List<Person> findAll() throws Exception{
        return service.findAll();
    }


}
