package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    
    public Admin() {
        super();
    }

    public Admin(int id, String name, String email, String address, String phoneNumber) {
        super(id, name, email, address, phoneNumber);
    }
    
}
