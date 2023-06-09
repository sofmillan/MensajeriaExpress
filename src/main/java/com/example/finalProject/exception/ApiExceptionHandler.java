package com.example.finalProject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value={DataNotFoundException.class})
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e){
        ApiException apiException= new ApiException(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={InvalidDataException.class})
    public ResponseEntity<Object> handleInvalidDataException(InvalidDataException e){
        ApiException apiException= new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value={DataAlreadyExistsException.class})
    public ResponseEntity<Object> handleDataAlreadyExistsException(DataAlreadyExistsException e){
        ApiException apiException= new ApiException(
                e.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }
}
