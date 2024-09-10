package com.fitness.cs.fitness_project_be.utils;

import com.fitness.cs.fitness_project_be.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private UserRole role;
    private String message;



}
