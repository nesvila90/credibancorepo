package com.example.integraciones.commons.exceptions.wsclient;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class ServiceClientException extends ServiceException {

    public ServiceClientException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public ServiceClientException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
