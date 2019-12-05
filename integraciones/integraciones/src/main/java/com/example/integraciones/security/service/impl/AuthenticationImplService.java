package com.example.integraciones.security.service.impl;

import com.example.integraciones.commons.enums.LogRefServicios;
import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.security.exceptions.PortalJwtException;
import com.example.integraciones.security.jwt.CustomUserDetailsImplService;
import com.example.integraciones.security.jwt.JwtTokenProvider;
import com.example.integraciones.security.model.AuthenticationRequest;
import com.example.integraciones.security.model.AuthenticationResponse;
import com.example.integraciones.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class AuthenticationImplService implements AuthenticationService {

    public static final String TOKEN_TYPE = "Bearer";

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenUtil;

    @Qualifier(value = "customUserDetailsImplService")
    private CustomUserDetailsImplService userDetailsService;

    @Autowired
    public AuthenticationImplService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenUtil, CustomUserDetailsImplService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public AuthenticationResponse singin(AuthenticationRequest authData) throws ServiceException {
        authenticate(authData.getUsername(), authData.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authData.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return AuthenticationResponse.builder().dateGenerated(LocalDateTime.now()).username(userDetails.getUsername()).token(token).type(TOKEN_TYPE).build();
    }

    private void authenticate(String username, String password) throws ServiceException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new PortalJwtException(LogRefServicios.ERROR_USUARIO_DESHABILITADO, e.getMessage());
        } catch (BadCredentialsException e) {
            throw new ServiceException(LogRefServicios.ERROR_JWT_SEGURIDAD, "Credenciales Invalidas.");
        }
    }
}
