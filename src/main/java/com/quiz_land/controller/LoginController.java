package com.quiz_land.controller;

import com.quiz_land.model.User;
import com.quiz_land.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginRepository loginRepository;

    @GetMapping()
    public List<User> getUsers() {
        return loginRepository.findAll();
    }
}
