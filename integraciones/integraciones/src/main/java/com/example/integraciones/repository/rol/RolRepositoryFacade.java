package com.example.integraciones.repository.rol;

import com.example.integraciones.domain.entity.Rol;

import java.util.List;

public interface RolRepositoryFacade {

    Rol create(Rol person);

    Rol findById(String typeId, Long id);

    List<Rol> findAll();

    Rol update(Rol person);

    void delete(Long id);

}
