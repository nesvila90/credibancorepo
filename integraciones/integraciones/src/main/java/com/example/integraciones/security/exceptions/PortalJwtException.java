package com.example.integraciones.security.exceptions;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;

public class PortalJwtException extends ServiceException {

    public PortalJwtException(LogRefServicios logRefServicios, String message) {
        super(logRefServicios, message);
    }

    public PortalJwtException(LogRefServicios logRefServicios, String message, Throwable cause) {
        super(logRefServicios, message, cause);
    }
}
