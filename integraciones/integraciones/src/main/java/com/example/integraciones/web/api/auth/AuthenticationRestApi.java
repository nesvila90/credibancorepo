package com.example.integraciones.web.api.auth;

import com.example.integraciones.security.AuthenticationService;
import com.example.integraciones.security.model.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestApi {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationRestApi(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data){
        return new ResponseEntity(authenticationService.singin(data), HttpStatus.OK);
    }

}
