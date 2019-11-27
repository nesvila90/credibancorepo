package com.example.integraciones.service.person;

import com.example.integraciones.commons.exceptions.persistence.DataCorruptedPersistenceException;
import com.example.integraciones.commons.exceptions.persistence.PortalPersistenceException;
import com.example.integraciones.domain.entity.enums.IdType;
import com.example.integraciones.domain.entity.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person) throws DataCorruptedPersistenceException, PortalPersistenceException;

    Person findByIdAndTypeId(Long id, IdType typeId);

    List<Person> findAll();

    Person update(Person person);

    void delete(Long id, IdType typeId);
}
