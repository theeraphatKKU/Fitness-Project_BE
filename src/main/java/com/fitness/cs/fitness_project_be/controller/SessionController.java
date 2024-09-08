package com.fitness.cs.fitness_project_be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.cs.fitness_project_be.model.Session;
import com.fitness.cs.fitness_project_be.service.SessionService;

@RestController
@RequestMapping("/api/session")
public class SessionController {
    
    @Autowired
    SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<Session>> getAllSession(){
        return new ResponseEntity<>(sessionService.getAllSessions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Session>> getSessionById(@PathVariable("sessionId") Integer sessionId){
        return new ResponseEntity<>(sessionService.getSessionById(sessionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session newSession){
        return new ResponseEntity<>(sessionService.createSession(newSession), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSession(@PathVariable("sessionId") Integer sessionId, @RequestBody Session updateSession){
        try{
            sessionService.updateSession(sessionId, updateSession);
            return ResponseEntity.status(404).body("Session ID: " + sessionId + " has been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(404).body("Trainer not found with ID: " + sessionId);
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSession(@PathVariable("sessionId") Integer sessionId){
        try{
            sessionService.deleteSession(sessionId);
            return ResponseEntity.ok("Session with ID: " + sessionId + " has been deleted.");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("Session not found with ID: " + sessionId);
        }
    }
}