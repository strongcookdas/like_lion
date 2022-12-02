package com.example.study_springboot_login.login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"중복된 user name입니다.");

    private HttpStatus httpStatus;
    private String message;
}
