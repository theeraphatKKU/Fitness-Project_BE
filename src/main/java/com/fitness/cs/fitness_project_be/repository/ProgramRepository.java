package com.fitness.cs.fitness_project_be.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fitness.cs.fitness_project_be.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{
    
}
