package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Data
@Entity
public class User extends BaseEntity {

    private String username;
    private Boolean state;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
    private Rol rol;


}
