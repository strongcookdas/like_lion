package com.example.springboot_visithistory.hospital.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserJoinRequest {

    private String userName;
    private String password;

}
