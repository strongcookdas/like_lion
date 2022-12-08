package com.example.springboot_visithistory.hospital.service;

import com.example.springboot_visithistory.hospital.configuration.EncoderConfig;
import com.example.springboot_visithistory.hospital.domain.entity.User;
import com.example.springboot_visithistory.hospital.exception.AppException;
import com.example.springboot_visithistory.hospital.exception.ErrorCode;
import com.example.springboot_visithistory.hospital.repository.UserRepository;
import com.example.springboot_visithistory.hospital.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.token.secret}")
    private String key;

    private Long expireTime = 1000*60*60l;

    public String join(String userName, String password){

        //userName 중복 check
        userRepository.findByUserName(userName).ifPresent(user->{
            throw new AppException(ErrorCode.DUPLICATED_USER_NAME,ErrorCode.DUPLICATED_USER_NAME.getMessage());
        });

        userRepository.save(User.toEntity(userName,encoder.encode(password)));
        return "SUCCESS";
    }

    public String login(String userName, String password){

        // userName없는 경우
       User selectedUser = userRepository.findByUserName(userName).orElseThrow(() -> {
            throw new AppException(ErrorCode.NOTFOUND_USER_NAME,ErrorCode.NOTFOUND_USER_NAME.getMessage());
        });

        // password가 다른 경우
        if(!encoder.matches(password,selectedUser.getPassword())) throw new AppException(ErrorCode.INVALID_PASSWORD,ErrorCode.INVALID_PASSWORD.getMessage());

        String token = JwtTokenUtil.createToken(userName,key,expireTime);
        return token;
    }
}
