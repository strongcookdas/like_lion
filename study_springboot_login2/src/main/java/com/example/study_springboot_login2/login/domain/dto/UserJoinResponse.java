package com.example.study_springboot_login2.login.domain.dto;

import lombok.*;

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
