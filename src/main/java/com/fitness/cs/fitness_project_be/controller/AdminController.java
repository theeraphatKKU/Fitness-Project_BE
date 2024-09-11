package com.fitness.cs.fitness_project_be.controller;

import com.fitness.cs.fitness_project_be.model.Admin;
import com.fitness.cs.fitness_project_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        System.out.println("Created");
        return adminRepository.save(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminRepository.deleteById(id);
    }
}
