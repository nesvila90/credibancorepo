package com.example.integraciones.service.user.impl;

import com.example.integraciones.domain.entity.UserApp;
import com.example.integraciones.domain.model.dto.UserDTO;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import com.example.integraciones.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
class UserImplService implements UserService {

    private final UserRepositoryFacade userRepositoryFacade;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserImplService(UserRepositoryFacade userRepositoryFacade, PasswordEncoder passwordEncoder) {
        this.userRepositoryFacade = userRepositoryFacade;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserApp create(UserDTO user) {

        UserApp userApp = new UserApp();
        userApp.setUsername(user.getUsername());
        userApp.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepositoryFacade.create(userApp);
    }

    @Override
    public UserApp validate(String username, String password) {
        return null;
    }

    @Override
    public UserApp findByUsername(String nickname) {
        return null;
    }

    @Override
    public List<UserApp> findAllUser() {
        return null;
    }

    @Override
    public UserApp updateUser(UserApp person) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
