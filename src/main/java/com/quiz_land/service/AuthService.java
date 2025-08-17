package com.quiz_land.service;

import com.quiz_land.dto.LoginDto;
import com.quiz_land.dto.RegisterDto;
import com.quiz_land.model.Role;
import com.quiz_land.model.UserEntity;
import com.quiz_land.repository.RoleRepository;
import com.quiz_land.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public ResponseEntity<String> register(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();

        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleRepository.findByName("USER").get();

        user.setRole(Collections.singletonList(role));

        userRepository.save(user);

        return new ResponseEntity<>("User " + registerDto.getUsername() + "registered successfully", HttpStatus.OK);

    }

    public ResponseEntity<String> login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User " + loginDto.getUsername() + "signed in successfully", HttpStatus.OK);
    }
}
