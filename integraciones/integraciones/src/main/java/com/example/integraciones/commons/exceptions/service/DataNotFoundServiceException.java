package com.example.integraciones.commons.exceptions.service;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class DataNotFoundServiceException extends ServiceException {

    public DataNotFoundServiceException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public DataNotFoundServiceException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
