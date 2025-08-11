package com.quiz_land.controller;

import com.quiz_land.model.User;
import com.quiz_land.repository.UserRepository;
import com.quiz_land.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("login")
    public void login(@RequestBody User user) {

    }

    @PostMapping("register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @GetMapping("{id}")
    public User getUsers(@PathVariable Long id) {
        User foundUser = null;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            foundUser = userOptional.get();
        }
        return foundUser;
    }
}