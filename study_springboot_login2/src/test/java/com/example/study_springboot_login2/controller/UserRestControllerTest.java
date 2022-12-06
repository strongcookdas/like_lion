package com.example.study_springboot_login2.controller;

import com.example.study_springboot_login2.login.domain.dto.UserDto;
import com.example.study_springboot_login2.login.domain.dto.UserJoinRequest;
import com.example.study_springboot_login2.login.domain.dto.UserJoinResponse;
import com.example.study_springboot_login2.login.domain.dto.UserLoginRequest;
import com.example.study_springboot_login2.login.exception.ErrorCode;
import com.example.study_springboot_login2.login.exception.UserJoinException;
import com.example.study_springboot_login2.login.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    UserJoinRequest userJoinRequest = UserJoinRequest.builder()
            .userName("홍길동")
            .password("0000")
            .email("email@gmail.com")
            .build();

    @Test
    @DisplayName("회원가입 성공")
    @WithMockUser
    void join_success() throws Exception {

        when(userService.join(any())).thenReturn(mock(UserDto.class));

        mockMvc.perform(post("/api/v1/user/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패")
    @WithMockUser
    void join_fail() throws Exception {

        when(userService.join(any())).thenThrow(new UserJoinException(ErrorCode.DUPLICATED_USER_NAME, ErrorCode.DUPLICATED_USER_NAME.getMessage()));

        mockMvc.perform(post("/api/v1/user/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("로그인 성공")
    @WithAnonymousUser
    void login_success() throws Exception{

        when(userService.login(any(),any()))
                .thenReturn("token");

        mockMvc.perform(post("/api/v1/user/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest("홍길동", "0000"))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 실패 user name 존재하지 않음")
    @WithMockUser
    void login_failed1() throws Exception{

        when(userService.login(any(),any()))
                .thenThrow(new UserJoinException(ErrorCode.USER_NAME_NOTFOUND,ErrorCode.USER_NAME_NOTFOUND.getMessage()));

        mockMvc.perform(post("/api/v1/user/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest("홍길동", "0000"))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("로그인 실패 비밀번호가 다름")
    @WithMockUser
    void login_failed() throws Exception{

        when(userService.login(any(),any()))
                .thenThrow(new UserJoinException(ErrorCode.INVALID_PASSWORD,ErrorCode.INVALID_PASSWORD.getMessage()));

        mockMvc.perform(post("/api/v1/user/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserLoginRequest("홍길동", "0000"))))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}