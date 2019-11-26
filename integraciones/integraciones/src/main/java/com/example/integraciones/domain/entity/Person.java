package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import com.example.integraciones.domain.entity.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Person extends BaseEntity {


    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)

    private IdType idType;
    @Column(unique = true, nullable = false)
    private Long identification;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String lastname;
    @Column(unique = true, nullable = false)
    private Date date;

}
