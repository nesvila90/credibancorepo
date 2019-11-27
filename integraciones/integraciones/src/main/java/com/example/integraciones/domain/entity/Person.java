package com.example.integraciones.domain.entity;

import com.example.integraciones.domain.entity.base.BaseEntity;
import com.example.integraciones.domain.entity.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Person extends BaseEntity {


    @ApiModelProperty(value = "Type Id", example = "CC")
    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private IdType idType;

    @ApiModelProperty(value = "Identification", example = "123456789")
    @Column(unique = true, nullable = false)
    private Long identification;

    @ApiModelProperty(value = "Name", example = "Nestor")
    @Column(unique = true, nullable = false)
    private String name;

    @ApiModelProperty(value = "lastName", example = "Villar")
    @Column(unique = true, nullable = false)
    private String lastname;

    @ApiModelProperty(value = "Date", example = "2019/05/10")
    @Column(unique = true, nullable = false)
    private Date date;

}
