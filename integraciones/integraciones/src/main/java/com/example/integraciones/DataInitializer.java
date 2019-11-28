package com.example.integraciones;

import com.example.integraciones.domain.entity.Rol;
import com.example.integraciones.domain.entity.enums.RolType;
import com.example.integraciones.repository.rol.RolRepositoryFacade;
import com.example.integraciones.repository.rol.RolRespository;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.integraciones.domain.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {



    @Autowired
    private UserRepositoryFacade users;

    @Autowired
    private RolRepositoryFacade rolRepositoryFacade;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override

    public void run(String... args) throws Exception {

        Rol rolAdmin = new Rol();
        rolAdmin.setId(1L);
        rolAdmin.setRol(RolType.ADMIN);

        rolRepositoryFacade.create(rolAdmin);

        Set<Rol> roles = new HashSet<>();
        roles.add(rolAdmin);


        this.users.create(User.builder()
                .usernameApp("admin")
                .passwordApp(this.passwordEncoder.encode("12345"))
                .roles(roles)
                .build()
        );



        log.debug("printing all users...");
        this.users.findAllUser().forEach(v -> log.debug(" User :" + v.toString()));
    }
}
