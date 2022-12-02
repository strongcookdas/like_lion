package com.example.study_springboot_login.login.controller;

import com.example.study_springboot_login.login.domain.dto.UserJoinRequest;
import com.example.study_springboot_login.login.domain.dto.UserJoinResponse;
import com.example.study_springboot_login.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<UserJoinResponse> userJoin(@RequestBody UserJoinRequest userJoinRequest){
        return ResponseEntity.ok().body(userService.join(userJoinRequest));
    }

}
