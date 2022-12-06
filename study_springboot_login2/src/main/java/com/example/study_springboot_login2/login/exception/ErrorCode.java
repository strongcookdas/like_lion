package com.example.study_springboot_login2.login.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"중복된 user name입니다."),
    USER_NAME_NOTFOUND(HttpStatus.NOT_FOUND,"존재하지 않는 user name입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED,"비밀번호가 틀립니다.");

    private HttpStatus httpStatus;
    private String message;
}
