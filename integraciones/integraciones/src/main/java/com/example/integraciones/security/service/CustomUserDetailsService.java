package com.example.integraciones.security.service;

import com.example.integraciones.repository.user.UserRepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepositoryFacade userRepositoryFacade;

    @Autowired
    public CustomUserDetailsService(UserRepositoryFacade userRepositoryFacade) {
        this.userRepositoryFacade = userRepositoryFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(this.userRepositoryFacade.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }

}