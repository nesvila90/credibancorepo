package com.example.integraciones.commons.exceptions.service;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class DataCorruptedServiceException extends ServiceException {

    public DataCorruptedServiceException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public DataCorruptedServiceException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
