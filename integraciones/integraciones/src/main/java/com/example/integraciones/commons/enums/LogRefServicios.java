package com.example.integraciones.commons.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LogRefServicios {

    ERROR_GENERAL_SERVICIO("ERROR_GENERAL_SERVICIO", "/ayuda/error_general_servicio.html"),
    ERROR_PERSISTENCIA("ERROR_PERSISTENCIA", "/ayuda/error_persistencia.html"),
    ERROR_CLIENTE_SERVICIO("ERROR_CLIENTE_SERVICIO", "/ayuda/error_cliente_servicio.html"),
    ERROR_DATO_CORRUPTO("ERROR_DATO_CORRUPTO", "/ayuda/error_general_servicio.html"),
    ERROR_DATO_NO_ENCONTRADO("ERROR_DATO_NO_ENCONTRADO", "/ayuda/error_general_servicio.html");

    /**
     * Codigo del error
     */
    private @Getter
    String logRef;
    /**
     * Enlace a la pagina con ayuda
     */
    private @Getter
    String hrefLink;

    public static LogRefServicios valueOfLogRef(String logRef) {
        for (LogRefServicios item : values()) {
            if (item.getLogRef().equals(logRef)) {
                return item;
            }
        }
        return null;
    }
}
