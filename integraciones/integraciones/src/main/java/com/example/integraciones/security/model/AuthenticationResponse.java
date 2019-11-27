package com.example.integraciones.security.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class AuthenticationResponse {
    private String username;
    private String token;
    private String type;
    private LocalDateTime dateGenerated;

}
