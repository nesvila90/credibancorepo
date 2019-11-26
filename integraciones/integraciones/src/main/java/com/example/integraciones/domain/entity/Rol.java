package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import com.example.integraciones.domain.entity.enums.RolType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rol extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RolType rol;
}

