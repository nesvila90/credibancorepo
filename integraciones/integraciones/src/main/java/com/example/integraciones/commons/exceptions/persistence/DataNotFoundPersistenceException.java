package com.example.integraciones.commons.exceptions.persistence;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class DataNotFoundPersistenceException extends ServiceException {


    public DataNotFoundPersistenceException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public DataNotFoundPersistenceException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
