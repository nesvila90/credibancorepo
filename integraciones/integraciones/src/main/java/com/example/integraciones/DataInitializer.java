package com.example.integraciones;

import com.example.integraciones.domain.entity.Rol;
import com.example.integraciones.domain.entity.UserApp;
import com.example.integraciones.domain.entity.enums.RolType;
import com.example.integraciones.repository.rol.RolRepositoryFacade;
import com.example.integraciones.repository.user.UserRepositoryFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {


    @Autowired
    private UserRepositoryFacade users;

    @Autowired
    private RolRepositoryFacade rolRepositoryFacade;

    @Autowired
    PasswordEncoder bcryptEncoder;

    @Override

    public void run(String... args) throws Exception {
        try {

            Rol rolAdmin = new Rol();
            rolAdmin.setId(1L);
            rolAdmin.setRol(RolType.ADMIN);

            rolRepositoryFacade.create(rolAdmin);

            Set<Rol> roles = new HashSet<>();
            roles.add(rolAdmin);


            this.users.create(UserApp.builder()
                    .username("admin")
                    .password(bcryptEncoder.encode("12345"))
                    .roles(new HashSet<>())
                    .build()
            );

            log.debug("printing all users...");
            this.users.findAllUser().forEach(v -> log.debug(" User :" + v.toString()));
        } catch (Exception e) {
            log.info(e.getCause().toString());
        }

    }
}
