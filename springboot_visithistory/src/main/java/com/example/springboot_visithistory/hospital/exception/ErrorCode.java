package com.example.springboot_visithistory.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT,"중복된 user name입니다."),
    NOTFOUND_USER_NAME(HttpStatus.NOT_FOUND,"해당하는 user name이 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "password가 다릅니다.");
    private HttpStatus httpStatus;
    private String message;
}
