package org.app.custom.errorlist.controller;

import org.app.custom.errorlist.exception.CustomException;
import org.app.custom.errorlist.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice is a specialization of the @Component annotation which allows to handle
 * exceptions across the whole application in one global handling component.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ErrorResponse> exception(CustomException ex) {
        return new ResponseEntity<>(ex.getErrorResponse(), HttpStatus.resolve(ex.getStatusCode()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
