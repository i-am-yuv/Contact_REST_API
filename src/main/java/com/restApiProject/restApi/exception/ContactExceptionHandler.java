package com.restApiProject.restApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactExceptionHandler {

    @ExceptionHandler(value = {ContactNotFoundException.class})
    public ResponseEntity<Object> handleContactNotFoundException
            (ContactNotFoundException contactNotFoundException)
    {
        ContactException contactException = new ContactException(
                contactNotFoundException.getMessage(),
                contactNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(contactException, HttpStatus.NOT_FOUND);
    }
}
