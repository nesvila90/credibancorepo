package com.example.integraciones.security;

import com.example.integraciones.security.model.AuthenticationRequest;
import com.example.integraciones.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse singin(AuthenticationRequest authData);
}
