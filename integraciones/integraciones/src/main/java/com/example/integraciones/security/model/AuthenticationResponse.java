package com.example.integraciones.security.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
public class AuthenticationResponse implements Serializable {
    private String username;
    private String token;
    private String type;
    private LocalDateTime dateGenerated;

}
