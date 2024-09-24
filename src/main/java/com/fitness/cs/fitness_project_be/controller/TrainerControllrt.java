package com.fitness.cs.fitness_project_be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.cs.fitness_project_be.model.Trainer;
import com.fitness.cs.fitness_project_be.service.TrainerService;

@RestController
@RequestMapping("/api/trainer")
public class TrainerControllrt {

    @Autowired
    TrainerService trainerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainer() {
        return new ResponseEntity<>(trainerService.getAllTrainers(), HttpStatus.OK);
    }

    // @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('TRAINER')")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Trainer>> getTrainerById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(trainerService.getTrainerById(id), HttpStatus.OK);
    }

    // @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('TRAINER')")
    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer newTrainer) {
        newTrainer.setPassword(passwordEncoder.encode(newTrainer.getPassword()));
        return new ResponseEntity<>(trainerService.createTrainer(newTrainer), HttpStatus.OK);
    }

    // @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('TRAINER')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTrainer(@PathVariable("id") Integer id, @RequestBody Trainer updateTrainer){
        try{
            trainerService.updateTrainer(id, updateTrainer);
            return ResponseEntity.ok("Trainer ID: " + id + " has been deleted.");
        }catch (Exception e){
            return ResponseEntity.status(404).body("Trainer not found with ID: " + id);
        } 
    }

    // @PreAuthorize("hasAuthority('ADMIN') || hasAutority('TRAINER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") Integer id){
        try{
            trainerService.deleteTrainer(id);
            return ResponseEntity.ok("Trainer with ID: " + id + " has been deleted.");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("Trainer not found with ID: " + id);
        } 
    }
}