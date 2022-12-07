package com.example.springboot_visithistory.hospital.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<?> appException(AppException e){
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(e.getErrorCode().getMessage());
    }
}
