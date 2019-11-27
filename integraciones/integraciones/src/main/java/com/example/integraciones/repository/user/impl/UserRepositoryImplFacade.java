package com.example.integraciones.repository.user.impl;

import com.example.integraciones.domain.entity.User;
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
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User validate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByUsername(String nickname) {
        return userRepository.findByUsername(nickname);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userToModify = findByUsername(user.getUsername());
        userToModify.setState(ObjectUtils.defaultIfNull(user.getState(), userToModify.getState()));
        userToModify.setPassword(ObjectUtils.defaultIfNull(user.getPassword(), userToModify.getPassword()));
        userToModify.setRoles(ObjectUtils.defaultIfNull(user.getRoles(), userToModify.getRoles()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {

    }

}
