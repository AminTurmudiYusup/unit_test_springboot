package com.example.unittest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> badRequestException(BadRequestException badRequestException) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(String.valueOf(badRequestException.getHttpStatus()));
        errorMessage.setMessage(badRequestException.getMessage());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
