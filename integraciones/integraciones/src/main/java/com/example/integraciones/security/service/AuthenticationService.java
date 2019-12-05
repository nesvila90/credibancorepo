package com.example.integraciones.security.service;

import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.security.model.AuthenticationRequest;
import com.example.integraciones.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse singin(AuthenticationRequest authData) throws ServiceException;
}
