package com.example.integraciones.commons.exceptions.base;

import com.example.integraciones.commons.enums.LogRefServicios;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends Exception {

    private LogRefServicios logRefServicios;

    private String message;

    public ServiceException(LogRefServicios logRefServicios, String message) {
        super(message);
        this.logRefServicios = logRefServicios;
        this.message = message;
    }

    public ServiceException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(message, cause);
        this.logRefServicios = logRefServicios;
        this.message = message;
    }
}
