package com.example.study_springboot_login2.login.service;


import com.example.study_springboot_login2.login.domain.dto.UserDto;
import com.example.study_springboot_login2.login.domain.dto.UserJoinRequest;
import com.example.study_springboot_login2.login.domain.entity.User;
import com.example.study_springboot_login2.login.exception.ErrorCode;
import com.example.study_springboot_login2.login.exception.UserJoinException;
import com.example.study_springboot_login2.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserDto join(UserJoinRequest userJoinRequest) {
        Optional<User> optionalUser = userRepository.findByUserName(userJoinRequest.getUserName());
        optionalUser.ifPresent(user -> {
            throw new UserJoinException(ErrorCode.DUPLICATED_USER_NAME, String.format("이미 존재하는 회원 이름입니다."));
        });
        User savedUser = userRepository.save(userJoinRequest.toEntity(encoder.encode(userJoinRequest.getPassword())));
        return savedUser.toDto();
    }

    public String login(String userName, String password) {

        // userName 없음
        userRepository.findByUserName(userName)
                .orElseThrow(() -> new UserJoinException(ErrorCode.USER_NAME_NOTFOUND,ErrorCode.USER_NAME_NOTFOUND.getMessage()));

        // password 틀림

        return "token 발행";
    }
}
