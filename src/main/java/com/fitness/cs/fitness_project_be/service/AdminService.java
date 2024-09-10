package com.fitness.cs.fitness_project_be.service;

import com.fitness.cs.fitness_project_be.model.Admin;
import com.fitness.cs.fitness_project_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(int id, Admin admin) {
        if (adminRepository.existsById(id)) {
            return adminRepository.save(admin);
        }
        return null; // or throw an exception if preferred
    }

    public void deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        }
    }
}
