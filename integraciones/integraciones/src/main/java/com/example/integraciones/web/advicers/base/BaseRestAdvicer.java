package com.example.integraciones.web.advicers.base;

import com.example.integraciones.commons.exceptions.base.ServiceException;
import com.example.integraciones.commons.exceptions.persistence.PortalPersistenceException;
import com.example.integraciones.commons.exceptions.wsclient.ServiceClientException;
import com.example.integraciones.web.api.person.PersonRestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class BaseRestAdvicer {

    @ExceptionHandler
    public ResponseEntity<VndErrors> errorServiceExceptionHandler(final ServiceException serviceException){
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, serviceException.getClass());
        VndErrors vndErrors = buildVndError(serviceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<VndErrors> errorPortalPersistenceExceptionHandler(final PortalPersistenceException persistenceException){
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, persistenceException.getClass());
        VndErrors vndErrors = buildVndError(persistenceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<VndErrors> errorServiceClientExceptionHandler(final ServiceClientException serviceClientException){
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, serviceClientException.getClass());
        VndErrors vndErrors = buildVndError(serviceClientException);
        return new ResponseEntity<>(vndErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public final VndErrors buildVndError(ServiceException serviceException){
        final String logRef = serviceException.getLogRefServicios().getLogRef();
        final Link link= new Link(serviceException.getLogRefServicios().getHrefLink());
        final String message = serviceException.getMessage();
        return new VndErrors(logRef,message,link);
    }

}
