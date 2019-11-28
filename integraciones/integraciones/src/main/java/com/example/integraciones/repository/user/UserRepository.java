package com.example.integraciones.repository.user;

import com.example.integraciones.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAppAndPasswordApp(String username, String password);

    User findByUsernameApp(String username);
}
