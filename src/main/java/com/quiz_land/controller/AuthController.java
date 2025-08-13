package com.quiz_land.controller;

import com.quiz_land.dto.LoginDto;
import com.quiz_land.dto.RegisterDto;
import com.quiz_land.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        return authService.register(registerDto);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}
