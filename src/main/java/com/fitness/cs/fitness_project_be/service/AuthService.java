package com.fitness.cs.fitness_project_be.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.User;
import com.fitness.cs.fitness_project_be.model.UserRole;
import com.fitness.cs.fitness_project_be.repository.UserRepository;
import com.fitness.cs.fitness_project_be.utils.AuthResponse;
import com.fitness.cs.fitness_project_be.utils.LoginRequest;
import com.fitness.cs.fitness_project_be.utils.RegisterRequest;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private RefreshTokenService refreshTokenService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .address(registerRequest.getAddress())
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(UserRole.MEMBER)
                .build();

        User savedUser = userRepository.save(user);
        var accessToken = jwtService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getEmail());

        return AuthResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .role(UserRole.MEMBER)
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .message("Register success")
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                        )
        );

        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        var accessToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(loginRequest.getEmail());

        return AuthResponse.builder()
        .name(user.getName())
        .email(user.getEmail())
        .password(passwordEncoder.encode(user.getPassword()))
        .address(user.getAddress())
        .phoneNumber(user.getPhoneNumber())
        .role(UserRole.MEMBER)
        .accessToken(accessToken)
        .refreshToken(refreshToken.getRefreshToken())
        .message("Login success")
        .build();
    }
}
