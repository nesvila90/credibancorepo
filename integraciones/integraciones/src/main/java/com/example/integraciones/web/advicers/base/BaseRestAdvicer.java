package com.example.integraciones.web.advicers.base;

import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.commons.exceptions.persistence.PortalPersistenceException;
import com.example.integraciones.commons.exceptions.wsclient.ServiceClientException;
import com.example.integraciones.security.exceptions.PortalJwtException;
import com.example.integraciones.web.api.person.PersonRestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public abstract class BaseRestAdvicer {

    @ExceptionHandler
    protected ResponseEntity<VndErrors> errorServiceExceptionHandler(final ServiceException serviceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, serviceException.getClass());
        VndErrors vndErrors = buildVndError(serviceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    protected ResponseEntity<VndErrors> errorPortalPersistenceExceptionHandler(final PortalPersistenceException persistenceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, persistenceException.getClass());
        VndErrors vndErrors = buildVndError(persistenceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    protected ResponseEntity<VndErrors> errorServiceClientExceptionHandler(final ServiceClientException serviceClientException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, serviceClientException.getClass());
        VndErrors vndErrors = buildVndError(serviceClientException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    protected ResponseEntity<VndErrors> errorPortalJwtExceptionHandler(final PortalJwtException portalJwtException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class);
        VndErrors vndErrors = buildVndError(portalJwtException);
        return new ResponseEntity<>(vndErrors, HttpStatus.BAD_REQUEST);
    }

    protected final VndErrors buildVndError(ServiceException serviceException) {
        final String logRef = serviceException.getLogRefServicios().getLogRef();
        final Link link = new Link(serviceException.getLogRefServicios().getHrefLink());
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(serviceException.getMessage());
        if (!ObjectUtils.isEmpty(serviceException.getCause())) {
            messageBuilder.append(" - Excepción Lanzada: -").append(serviceException.getClass());
        }
        final String message = messageBuilder.toString();
        return new VndErrors(logRef, message, link);
    }

}
