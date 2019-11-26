package com.example.integraciones.domain.entity.enums;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.service.DataCorruptedServiceException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum IdType {

    CC("CC", "Cédula de Ciudadania.");

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final @Getter
    String type;

    private final @Getter
    String description;

    public static IdType findIdTypeByType(String type) throws DataCorruptedServiceException {
        return Stream.of(IdType.values()).filter(idType1 -> idType1.getType().equals(type)).findAny()
                .orElseThrow(() -> new DataCorruptedServiceException(LogRefServicios.ERROR_DATO_CORRUPTO, "Tipo de identificación incorrecta."));
    }

}
