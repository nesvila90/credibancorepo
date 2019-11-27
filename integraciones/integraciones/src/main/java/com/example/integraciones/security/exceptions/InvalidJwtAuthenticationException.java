package com.example.integraciones.security.exceptions;

import org.springframework.security.core.AuthenticationException;

import java.io.Serializable;

public class InvalidJwtAuthenticationException extends AuthenticationException implements Serializable {

    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}
