package com.project.service.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.resources.exceptions.StandardError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // intercepta as excessoes
public class ResourceExeceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // intercepta a excessao desse tipo
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err); // montagem do corpo do erro
    }

    @ExceptionHandler(DatabaseException.class) // intercepta a exceção do tipo DatabaseException
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err); // montagem do corpo do erro
    }

}
