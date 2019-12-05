package com.example.integraciones.service.user;

import com.example.integraciones.domain.entity.UserApp;
import com.example.integraciones.domain.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserApp create(UserDTO userApp);

    UserApp validate(String username, String password);

    UserApp findByUsername(String nickname);

    List<UserApp> findAllUser();

    UserApp updateUser(UserApp person);

    void deleteUser(Long id);
}
