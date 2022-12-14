package com.example.study_springboot_login2.login.domain.entity;

import com.example.study_springboot_login2.login.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;

    public UserDto toDto(){
        return UserDto.builder()
                .id(this.id)
                .userName(this.userName)
                .password(this.password)
                .email(this.email)
                .build();
    }

}
