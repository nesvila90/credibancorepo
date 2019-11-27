package com.example.integraciones.service.person.impl;

import com.example.integraciones.commons.exceptions.persistence.DataCorruptedPersistenceException;
import com.example.integraciones.commons.exceptions.persistence.PortalPersistenceException;
import com.example.integraciones.domain.entity.enums.IdType;
import com.example.integraciones.domain.entity.Person;
import com.example.integraciones.repository.person.PersonRepositoryFacade;
import com.example.integraciones.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImplService implements PersonService {

    private final PersonRepositoryFacade personRepositoryFacade;

    @Autowired
    public PersonaImplService(PersonRepositoryFacade personRepositoryFacade) {
        this.personRepositoryFacade = personRepositoryFacade;
    }

    @Override
    public Person create(Person person) throws DataCorruptedPersistenceException, PortalPersistenceException {
        return personRepositoryFacade.create(person);
    }

    @Override
    public Person findByIdAndTypeId(Long id, IdType typeId) {
        return personRepositoryFacade.findByIdAndTypeId(id, typeId);
    }

    @Override
    public List<Person> findAll() {
        return personRepositoryFacade.findAll();
    }

    @Override
    public Person update(Person person) {
        return personRepositoryFacade.update(person);
    }

    @Override
    public void delete(Long id, IdType typeId) {
        personRepositoryFacade.delete(id, typeId);
    }
}
