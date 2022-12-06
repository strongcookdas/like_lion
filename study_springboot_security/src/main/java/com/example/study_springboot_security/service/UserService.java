package com.example.study_springboot_security.service;

import com.example.study_springboot_security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.secret")
    private String secretKey;

    private Long expiredMs = 1000*60*60l;

    public String login(String userName,String password){
        return JwtUtil.createJwt(userName,secretKey,expiredMs);
    }
}
