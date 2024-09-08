package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.User;
import com.fitness.cs.fitness_project_be.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null; // Handle not found
    }
    
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
