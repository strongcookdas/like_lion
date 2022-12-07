package com.example.springboot_visithistory.hospital.service;

import com.example.springboot_visithistory.hospital.domain.entity.User;
import com.example.springboot_visithistory.hospital.exception.AppException;
import com.example.springboot_visithistory.hospital.exception.ErrorCode;
import com.example.springboot_visithistory.hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(String userName, String password){

        //userName 중복 check
        userRepository.findByUserName(userName).ifPresent(user->{
            throw new AppException(ErrorCode.DUPLICATED_USER_NAME,ErrorCode.DUPLICATED_USER_NAME.getMessage());
        });

        userRepository.save(User.toEntity(userName,password));
        return "SUCCESS";
    }
}
