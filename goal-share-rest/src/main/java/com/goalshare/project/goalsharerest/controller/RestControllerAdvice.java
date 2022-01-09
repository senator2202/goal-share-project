package com.goalshare.project.goalsharerest.controller;

import com.goalshare.project.goalsharerest.controller.exception.BindingResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@ControllerAdvice
public class RestControllerAdvice {

    public static final String NOT_FOUND_RESPONSE_MESSAGE = "Requested entity was not found";

    @ExceptionHandler(BindingResultException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> bindingResultExceptionHandler(BindingResultException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getErrorMap());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> entityNotFoundExceptionHandler(EntityNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(NOT_FOUND_RESPONSE_MESSAGE);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity<String> BadCredentialsExceptionHandler(BadCredentialsException exception) {
        return ResponseEntity.
                status(HttpStatus.UNAUTHORIZED)
                .body(exception.getLocalizedMessage());
    }
}
