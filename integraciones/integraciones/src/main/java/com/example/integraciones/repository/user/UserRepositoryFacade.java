package com.example.integraciones.repository.user;

import com.example.integraciones.domain.entity.UserApp;

import java.util.List;

public interface UserRepositoryFacade {

    UserApp create(UserApp userApp);

    UserApp validate(String username, String password);

    UserApp findByUsername(String nickname);

    List<UserApp> findAllUser();

    UserApp updateUser(UserApp person);

    void deleteUser(Long id);

}
