package com.example.integraciones.repository.person.impl;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.persistence.DataCorruptedPersistenceException;
import com.example.integraciones.commons.exceptions.persistence.PortalPersistenceException;
import com.example.integraciones.domain.entity.Person;
import com.example.integraciones.domain.entity.enums.IdType;
import com.example.integraciones.repository.person.PersonRepository;
import com.example.integraciones.repository.person.PersonRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
public class PersonRepositoryImplFacade implements PersonRepositoryFacade {

    private final PersonRepository personRepository;

    @Autowired
    public PersonRepositoryImplFacade(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) throws DataCorruptedPersistenceException, PortalPersistenceException {
        try {
            personRepository.saveAndFlush(person);
            return person;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al Violación de integridad al persistir: ", e);
            throw new DataCorruptedPersistenceException(LogRefServicios.ERROR_DATO_CORRUPTO, "Error al persistir la persona.", e);
        } catch (Exception e) {
            log.error("Error GENERAL al persistir: ", e);
            throw new PortalPersistenceException(LogRefServicios.ERROR_PERSISTENCIA, "Error en el motor de persistencia.", e);
        }

    }

    @Override
    public Person findByIdAndTypeId(Long id, IdType typeId) {
        return personRepository.findByIdentificationAndIdType(id, typeId);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person update(Person person) {
        Person personUpdate = personRepository.findByIdentificationAndIdType(person.getIdentification(), person.getIdType());
        personUpdate.setIdentification(ObjectUtils.defaultIfNull(person.getIdentification(), personUpdate.getIdentification()));
        personUpdate.setIdType(ObjectUtils.defaultIfNull(person.getIdType(), personUpdate.getIdType()));
        personUpdate.setName(ObjectUtils.defaultIfNull(person.getName(), personUpdate.getName()));
        personUpdate.setLastname(ObjectUtils.defaultIfNull(person.getLastname(), personUpdate.getLastname()));
        personUpdate.setDate(new Date(LocalDate.now().toEpochDay()));
        return personRepository.saveAndFlush(personUpdate);
    }

    @Override
    public void delete(Long id, IdType typeId) {
        Person personUpdate = personRepository.findByIdentificationAndIdType(id, typeId);
        personRepository.delete(personUpdate);
    }
}
