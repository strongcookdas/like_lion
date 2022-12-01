package com.example.study_springboot_login.exception.service;

import com.example.study_springboot_login.exception.domain.User;
import com.example.study_springboot_login.exception.exception.ErrorCode;
import com.example.study_springboot_login.exception.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public User getUser(String name) {
        Optional<User> opt = Optional.empty();
        opt.orElseThrow(() -> {
            throw new RuntimeException(String.format("%s이 없습니다.", name));
        });
        return opt.get();
    }

    public User getUser2(String name) {
        Optional<User> opt = Optional.empty();
        opt.orElseThrow(() -> {
            throw new UserException(ErrorCode.NOT_FOUND,String.format("%s을 찾을 수 없습니다.", name));
        });
        return opt.get();
    }
}
