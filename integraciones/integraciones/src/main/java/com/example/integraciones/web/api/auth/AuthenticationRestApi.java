package com.example.integraciones.web.api.auth;

import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.domain.model.dto.UserDTO;
import com.example.integraciones.security.model.AuthenticationRequest;
import com.example.integraciones.security.model.AuthenticationResponse;
import com.example.integraciones.security.service.AuthenticationService;
import com.example.integraciones.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticator")
public class AuthenticationRestApi {


    private final AuthenticationService authenticationService;

    private final UserService userService;

    @Autowired
    public AuthenticationRestApi(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws ServiceException, UsernameNotFoundException {
        AuthenticationResponse response = authenticationService.singin(authenticationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userService.create(user));
    }

}