package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User extends BaseEntity {

    @ApiModelProperty(value = "username", example = "nvillar")
    private String username;
    @ApiModelProperty(value = "state", example = "true")
    private Boolean state;
    @ApiModelProperty(value = "roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;


}
