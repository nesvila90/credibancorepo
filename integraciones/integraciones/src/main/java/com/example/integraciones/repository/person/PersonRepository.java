package com.example.integraciones.repository.person;

import com.example.integraciones.domain.entity.enums.IdType;
import com.example.integraciones.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.identification = :id AND p.idType=:idType")
    Person findByIdentificationAndIdType(@Param("id") Long identification, @Param("idType") IdType idType);
}
