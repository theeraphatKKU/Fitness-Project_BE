package com.fitness.cs.fitness_project_be.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}
