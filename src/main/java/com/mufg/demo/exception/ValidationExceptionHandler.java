package com.mufg.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handleApplicationException(RuntimeException ex, WebRequest request) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        
    }

    // when missing parameter
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleUncatchException(Exception ex, WebRequest request) {

        return new ResponseEntity<>("Please contact System Admin to resolve problem", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
