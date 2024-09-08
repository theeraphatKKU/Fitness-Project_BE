package com.fitness.cs.fitness_project_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitness.cs.fitness_project_be.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
