package com.fitness.cs.fitness_project_be.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Trainer extends User {
    
    String specialization;
    @OneToMany
    List<Scheduler> available;

    public Trainer() {
        super();
    }
    
    public Trainer(int id, String name, String email, String password, String address, String phoneNumber, String role, String specialization, List<Scheduler> available){
        super(id, name, email, password, address, phoneNumber, role);
        this.specialization = specialization;
        this.available = available;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public List<Scheduler>  getAvailable() {
        return available;
    }
    public void setAvailable(List<Scheduler>  available) {
        this.available = available;
    }

    
}
