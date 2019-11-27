package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import com.example.integraciones.domain.entity.enums.RolType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Rol extends BaseEntity {

    @ApiModelProperty(value = "Type Id", example = "USER")
    @Enumerated(EnumType.STRING)
    private RolType rol;
}

