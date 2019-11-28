package com.example.integraciones.security;

import com.example.integraciones.domain.entity.Rol;
import com.example.integraciones.domain.entity.enums.RolType;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import com.example.integraciones.security.model.AuthenticationRequest;
import com.example.integraciones.security.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.stream.Collectors.toList;

@Service
class AuthenticationImplService implements AuthenticationService {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    private UserRepositoryFacade userRepositoryFacade;

    @Autowired
    public AuthenticationImplService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepositoryFacade userRepositoryFacade) throws BadCredentialsException {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepositoryFacade = userRepositoryFacade;
    }

    @Override
    public AuthenticationResponse singin(AuthenticationRequest authData) {
        try {
            final String username = authData.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authData, authData.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.userRepositoryFacade.findByUsername(username).getRoles()
                    .stream().map(Rol::getRol)
                    .map(RolType::getName).collect(toList()));
            return AuthenticationResponse.builder().username(username).token(token).dateGenerated(LocalDateTime.now()).build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
