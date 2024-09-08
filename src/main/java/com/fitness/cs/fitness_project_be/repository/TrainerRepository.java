package com.fitness.cs.fitness_project_be.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.cs.fitness_project_be.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    
}