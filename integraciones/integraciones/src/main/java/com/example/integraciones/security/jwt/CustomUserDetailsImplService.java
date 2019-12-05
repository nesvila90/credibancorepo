package com.example.integraciones.security.jwt;

import com.example.integraciones.domain.entity.UserApp;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class CustomUserDetailsImplService implements CustomUserDetails {

    @Autowired
    private UserRepositoryFacade userRepositoryFacade;

/*    @Autowired
    private PasswordEncoder bcryptEncoder;
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserApp userApp = userRepositoryFacade.findByUsername(username);
        if (userApp == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(userApp.getUsername(), userApp.getPassword(),
                new ArrayList<>());
    }
/*
    public UserApp save(UserDTO user) {
        UserApp newUserApp = new UserApp();
        newUserApp.setUsername(user.getUsername());
        newUserApp.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepositoryFacade.create(newUserApp);
    }
*/
}