package com.fitness.cs.fitness_project_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.cs.fitness_project_be.model.RefreshToken;
import com.fitness.cs.fitness_project_be.model.User;
import com.fitness.cs.fitness_project_be.service.AuthService;
import com.fitness.cs.fitness_project_be.service.JwtService;
// import com.fitness.cs.fitness_project_be.service.RefreshTokenService;
import com.fitness.cs.fitness_project_be.utils.AuthResponse;
import com.fitness.cs.fitness_project_be.utils.LoginRequest;
import com.fitness.cs.fitness_project_be.utils.RefreshTokenRequest;
import com.fitness.cs.fitness_project_be.utils.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // @Autowired
    // private RefreshTokenService refreshTokenService;

    @Autowired
    private JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        // this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    // @PostMapping("/refresh")
    // public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {

    //     // RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(refreshTokenRequest.getRefreshToken());
    //     // User user = refreshToken.getUser();

    //     String accessToken = jwtService.generateToken(user);

    //     return ResponseEntity.ok(AuthResponse.builder()
    //             .name(user.getName())
    //             .email(user.getEmail())
    //             .phoneNumber(user.getPhoneNumber())
    //             .role(user.getRole())
    //             .accessToken(accessToken)
    //             .refreshToken(refreshToken.getRefreshToken())
    //             .message("Renew Access Token")
    //             .build());
    // }
}
