package com.quiz_land.controller;

import com.quiz_land.model.User;
import com.quiz_land.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("login")
    public void login(@RequestBody User user) {

    }

    @PostMapping("register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }
}