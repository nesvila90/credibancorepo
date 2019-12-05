package com.example.integraciones.repository.user.impl;

import com.example.integraciones.domain.entity.UserApp;
import com.example.integraciones.repository.user.UserRepository;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImplFacade implements UserRepositoryFacade {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryImplFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserApp create(UserApp userApp) {
        return userRepository.save(userApp);
    }

    @Override
    public UserApp validate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserApp findByUsername(String nickname) {
        UserApp userApp = userRepository.findByUsername(nickname);
        return userApp;
    }

    @Override
    public List<UserApp> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserApp updateUser(UserApp userApp) {
        UserApp userAppToModify = findByUsername(userApp.getUsername());
        userAppToModify.setPassword(ObjectUtils.defaultIfNull(userApp.getPassword(), userAppToModify.getPassword()));
        userAppToModify.setRoles(ObjectUtils.defaultIfNull(userApp.getRoles(), userAppToModify.getRoles()));
        return userRepository.saveAndFlush(userApp);
    }

    @Override
    public void deleteUser(Long id) {

    }

}
