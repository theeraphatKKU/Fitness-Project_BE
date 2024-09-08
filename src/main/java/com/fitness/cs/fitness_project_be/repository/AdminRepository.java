package com.fitness.cs.fitness_project_be.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fitness.cs.fitness_project_be.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
