package com.fitness.cs.fitness_project_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitness.cs.fitness_project_be.model.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
