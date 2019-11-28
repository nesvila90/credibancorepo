package com.example.integraciones.repository.rol.impl;

import com.example.integraciones.domain.entity.Rol;
import com.example.integraciones.repository.rol.RolRepositoryFacade;
import com.example.integraciones.repository.rol.RolRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolRepositoryImplFacade implements RolRepositoryFacade {

    private final RolRespository rolRespository;

    @Autowired
    public RolRepositoryImplFacade(RolRespository rolRespository) {
        this.rolRespository = rolRespository;
    }

    @Override
    public Rol create(Rol rol) {
        return rolRespository.save(rol);
    }

    @Override
    public Rol findById(String typeId, Long id) {
        return null;
    }

    @Override
    public List<Rol> findAll() {
        return null;
    }

    @Override
    public Rol update(Rol rol) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
