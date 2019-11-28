package com.example.integraciones.domain.entity.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RolType {

    ADMIN(1,"ROLE_ADMIN"),
    USER(2,"ROLE_USER");
    private final Integer id;
    private final String name;
}
