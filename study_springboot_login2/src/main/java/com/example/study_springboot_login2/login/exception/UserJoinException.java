package com.example.study_springboot_login2.login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
}
