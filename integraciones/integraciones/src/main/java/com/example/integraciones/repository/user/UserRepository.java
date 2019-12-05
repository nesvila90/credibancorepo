package com.example.integraciones.repository.user;

import com.example.integraciones.domain.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {

    UserApp findByUsernameAndPassword(String username, String password);

    @Query("SELECT U FROM UserApp U WHERE U.username = :user")
    UserApp findByUsername(@Param("user") String user);
}
