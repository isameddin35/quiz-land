package com.quiz_land.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {
    @Size(min = 3, max = 20, message = "Username must be 3-20 characters")
    private String username;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}