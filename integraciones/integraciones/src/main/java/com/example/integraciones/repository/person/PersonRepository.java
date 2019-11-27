package com.example.integraciones.repository.person;

import com.example.integraciones.domain.entity.Person;
import com.example.integraciones.domain.entity.enums.IdType;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@RepositoryRestResource(path = "people", collectionResourceRel = "people", itemResourceRel = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.identification = :id AND p.idType=:idType")
    Person findByIdentificationAndIdType(@Param("id") Long identification, @Param("idType") IdType idType);

    @Bean
    default AuditorAware<Person> auditor() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(Person.class::cast);
    }
}
