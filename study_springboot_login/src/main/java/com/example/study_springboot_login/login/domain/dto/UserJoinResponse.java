package com.example.study_springboot_login.login.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserJoinResponse {

    private String userName;
    private String email;

    public static UserJoinResponse of(String userName, String email){
        return UserJoinResponse.builder()
                .userName(userName)
                .email(email)
                .build();
    }
}
