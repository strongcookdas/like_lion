package com.example.study_springboot_login2.login.domain.dto;

import com.example.study_springboot_login2.login.domain.entity.User;
import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Builder
public class UserJoinRequest {

    private String userName;
    private String password;
    private String email;

    public User toEntity(){
        return User.builder()
                .userName(this.userName)
                .password(this.password)
                .email(this.email)
                .build();
    }
}
