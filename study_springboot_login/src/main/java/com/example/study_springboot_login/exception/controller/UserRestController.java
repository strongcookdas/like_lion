package com.example.study_springboot_login.exception.controller;

import com.example.study_springboot_login.exception.domain.User;
import com.example.study_springboot_login.exception.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exception")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/test1/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        return ResponseEntity.ok().body(userService.getUser(name));
    }

    @GetMapping("/test2/{name}")
    public ResponseEntity<User> getUser2(@PathVariable String name){
        return ResponseEntity.ok().body(userService.getUser2(name));
    }
}
