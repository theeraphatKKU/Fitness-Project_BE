package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.Trainer;
import com.fitness.cs.fitness_project_be.repository.TrainerRepository;

@Service
public class TrainerService {
    
    @Autowired
    private TrainerRepository trainerRepository;
    
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
    
    public Optional<Trainer> getTrainerById(int id) {
        return trainerRepository.findById(id);
    }
    
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(int id, Trainer updatedTrainer) {
        Optional<Trainer> existingTrainer = trainerRepository.findById(id);
        if (existingTrainer.isPresent()) {
            return trainerRepository.save(updatedTrainer);
        }
        return null; // Handle not found
    }
    
    public void deleteTrainer(int id) {
        trainerRepository.deleteById(id);
    }
}
