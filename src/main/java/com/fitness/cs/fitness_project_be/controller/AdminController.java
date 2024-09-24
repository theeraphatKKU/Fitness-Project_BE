package com.fitness.cs.fitness_project_be.controller;

import com.fitness.cs.fitness_project_be.model.Admin;
import com.fitness.cs.fitness_project_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminRepository.findById(id).orElse(null);
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminRepository.deleteById(id);
    }
}
