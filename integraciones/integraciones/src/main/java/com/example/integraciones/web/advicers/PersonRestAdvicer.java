package com.example.integraciones.web.advicers;

import com.example.integraciones.web.api.person.PersonRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = PersonRestApi.class)
public class PersonRestAdvicer {

    public ResponseEntity<VndError>

}
