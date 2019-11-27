package com.example.integraciones.web.advicers;

import com.example.integraciones.commons.exceptions.persistence.DataCorruptedPersistenceException;
import com.example.integraciones.commons.exceptions.persistence.DataNotFoundPersistenceException;
import com.example.integraciones.commons.exceptions.service.DataCorruptedServiceException;
import com.example.integraciones.commons.exceptions.service.DataNotFoundServiceException;
import com.example.integraciones.commons.exceptions.wsclient.ServiceClientConnectionException;
import com.example.integraciones.web.advicers.base.BaseRestAdvicer;
import com.example.integraciones.web.api.person.PersonRestApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Person rest advicer.
 */
@Slf4j
@ControllerAdvice(assignableTypes = PersonRestApi.class)
public class PersonRestAdvicer extends BaseRestAdvicer {

    /**
     * Error data corrupted persistence exception handler response entity.
     *
     * @param dataCorruptedPersistenceException the data corrupted persistence exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<VndErrors> errorDataCorruptedPersistenceExceptionHandler(final DataCorruptedPersistenceException dataCorruptedPersistenceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, dataCorruptedPersistenceException.getClass());
        VndErrors vndErrors = buildVndError(dataCorruptedPersistenceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.CONFLICT);
    }

    /**
     * Error data not found persistence exception handler response entity.
     *
     * @param dataNotFoundPersistenceException the data not found persistence exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<VndErrors> errorDataNotFoundPersistenceExceptionHandler(final DataNotFoundPersistenceException dataNotFoundPersistenceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, dataNotFoundPersistenceException.getClass());
        VndErrors vndErrors = buildVndError(dataNotFoundPersistenceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.NO_CONTENT);
    }


    /**
     * Error data corrupted service exception handler response entity.
     *
     * @param dataCorruptedServiceException the data corrupted service exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<VndErrors> errorDataCorruptedServiceExceptionHandler(final DataCorruptedServiceException dataCorruptedServiceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, dataCorruptedServiceException.getClass());
        VndErrors vndErrors = buildVndError(dataCorruptedServiceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Error data not found service exception handler response entity.
     *
     * @param dataNotFoundServiceException the data not found service exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<VndErrors> errorDataNotFoundServiceExceptionHandler(final DataNotFoundServiceException dataNotFoundServiceException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, dataNotFoundServiceException.getClass());
        VndErrors vndErrors = buildVndError(dataNotFoundServiceException);
        return new ResponseEntity<>(vndErrors, HttpStatus.NO_CONTENT);
    }

    /**
     * Error service client connection exception handler response entity.
     *
     * @param serviceClientConnectionException the service client connection exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<VndErrors> errorServiceClientConnectionExceptionHandler(final ServiceClientConnectionException serviceClientConnectionException) {
        log.info("Error Advicer - {0} - Exception type: {1}", PersonRestApi.class, serviceClientConnectionException.getClass());
        VndErrors vndErrors = buildVndError(serviceClientConnectionException);
        return new ResponseEntity<>(vndErrors, HttpStatus.SERVICE_UNAVAILABLE);
    }


}
