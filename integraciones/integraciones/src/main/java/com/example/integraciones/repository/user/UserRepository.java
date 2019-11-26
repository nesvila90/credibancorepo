package com.example.integraciones.repository.user;

import com.example.integraciones.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
