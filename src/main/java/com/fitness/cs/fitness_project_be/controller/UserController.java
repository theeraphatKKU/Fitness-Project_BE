package com.fitness.cs.fitness_project_be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fitness.cs.fitness_project_be.model.User;
import com.fitness.cs.fitness_project_be.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id ){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody User newUser){
        return new ResponseEntity<>(userService.createUser(newUser), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody User updateUser) {
        try{
            userService.updateUser(id, updateUser);
            return ResponseEntity.ok("User with ID " + id + " has been updated.");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("User not found with ID " + id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID: " + id + " has been deleted.");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("User not found with ID: " + id);
        }
    }
}