package com.example.springboot_visithistory.hospital.controller;

import com.example.springboot_visithistory.hospital.domain.dto.user.UserJoinRequest;
import com.example.springboot_visithistory.hospital.domain.dto.user.UserLoginRequest;
import com.example.springboot_visithistory.hospital.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospital/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest userJoinRequest){
        return ResponseEntity.ok().body(userService.join(userJoinRequest.getUserName(),userJoinRequest.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest userLoginRequest){
        String token = userService.login(userLoginRequest.getUserName(),userLoginRequest.getPassword());
        return ResponseEntity.ok().body(token);
    }
}
