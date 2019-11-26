package com.example.integraciones.web.api.person;

import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.domain.entity.Person;
import com.example.integraciones.domain.entity.enums.IdType;
import com.example.integraciones.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonRestApi {

    private final PersonService personService;

    @Autowired
    public PersonRestApi(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<Person>(personService.create(person), HttpStatus.CREATED);
    }


    @GetMapping("/type/{type}/id/{id}")
    public ResponseEntity<Person> find(@PathVariable("id") Long id, @PathVariable("type") String type) throws ServiceException {

        return new ResponseEntity<>(personService.findByIdAndTypeId(id, IdType.findIdTypeByType(type)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return new ResponseEntity<>(personService.update(person), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/type/{type}/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id, @PathVariable("type") String type) throws ServiceException {
        personService.delete(id, IdType.findIdTypeByType(type));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}