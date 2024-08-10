package com.webservicespring.project.resources.exception;

import com.webservicespring.project.services.exceptions.DatabaseException;
import com.webservicespring.project.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    private static final String RESOURCE_NOT_FOUND = "Resource not found";
    private static final String DATABASE_ERROR = "Database error";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound
            (ResourceNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), RESOURCE_NOT_FOUND, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        StandardError err = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), DATABASE_ERROR, e.getMessage(), request.getRequestURI());
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
        }

    }
