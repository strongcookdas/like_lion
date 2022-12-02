package com.example.study_springboot_login.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"resource is not found");

    private HttpStatus httpStatus;
    private String message;
}
