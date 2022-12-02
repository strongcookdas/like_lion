package com.example.study_springboot_login2.login.controller;

import com.example.study_springboot_login2.login.domain.dto.UserJoinRequest;
import com.example.study_springboot_login2.login.domain.dto.UserJoinResponse;
import com.example.study_springboot_login2.login.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<UserJoinResponse> userJoin(@RequestBody UserJoinRequest userJoinRequest) {
        log.info(userJoinRequest.toString());
        return ResponseEntity.ok().body(userService.join(userJoinRequest).toResponse());
    }

}
