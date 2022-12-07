package com.example.springboot_visithistory.hospital.service;

import com.example.springboot_visithistory.hospital.configuration.EncoderConfig;
import com.example.springboot_visithistory.hospital.domain.entity.User;
import com.example.springboot_visithistory.hospital.exception.AppException;
import com.example.springboot_visithistory.hospital.exception.ErrorCode;
import com.example.springboot_visithistory.hospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public String join(String userName, String password){

        //userName 중복 check
        userRepository.findByUserName(userName).ifPresent(user->{
            throw new AppException(ErrorCode.DUPLICATED_USER_NAME,ErrorCode.DUPLICATED_USER_NAME.getMessage());
        });

        userRepository.save(User.toEntity(userName,encoder.encode(password)));
        return "SUCCESS";
    }

    public String login(String userName, String password){
        return "token";
    }
}
