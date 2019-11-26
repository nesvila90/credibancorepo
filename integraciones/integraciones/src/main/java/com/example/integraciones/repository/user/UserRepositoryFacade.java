package com.example.integraciones.repository.user;

import com.example.integraciones.domain.entity.Person;
import com.example.integraciones.domain.entity.User;

import java.util.List;

public interface UserRepositoryFacade {

    User create(User user);

    User findById(String typeId, Long id);

    User findByUsername(String nickname);

    List<User> findAllUser();

    User updateUser(User person);

    void deleteUser(Long id);

}
