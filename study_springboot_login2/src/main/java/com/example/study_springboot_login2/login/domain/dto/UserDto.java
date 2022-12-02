package com.example.study_springboot_login2.login.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String email;

    public UserJoinResponse toResponse(){
        return UserJoinResponse.builder()
                .userName(this.userName)
                .email(this.email)
                .build();
    }
}
