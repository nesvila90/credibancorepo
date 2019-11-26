package com.example.integraciones.commons.exceptions.wsclient;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class ServiceClientConnectionException extends ServiceException {

    public ServiceClientConnectionException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public ServiceClientConnectionException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
