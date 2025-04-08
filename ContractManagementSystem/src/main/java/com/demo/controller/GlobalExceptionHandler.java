package com.demo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Handle Resource Not Found Exceptions
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException ex){
        return ResponseEntity.status(404).body("Resource Not Found.");
    }
    //Handle Invalid or Duplicate Data Exceptions
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrity(DataIntegrityViolationException ex){
        return ResponseEntity.status(400).body("Invalid data or Duplicate entry.");
    }
    //Handle Invalid Json Data Form Exceptions
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleInvalidJson(HttpMessageNotReadableException ex){
        return ResponseEntity.status(400).body("Invalid Json request.");
    }
    //Handle Internal Server Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return ResponseEntity.status(500).body("An unexpected error occur:" +ex.getClass().getSimpleName());
    }
}
