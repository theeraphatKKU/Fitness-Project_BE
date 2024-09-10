package com.fitness.cs.fitness_project_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.cs.fitness_project_be.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
