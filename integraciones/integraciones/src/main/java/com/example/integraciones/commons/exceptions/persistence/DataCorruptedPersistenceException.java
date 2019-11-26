package com.example.integraciones.commons.exceptions.persistence;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class DataCorruptedPersistenceException extends ServiceException {

    public DataCorruptedPersistenceException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public DataCorruptedPersistenceException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
