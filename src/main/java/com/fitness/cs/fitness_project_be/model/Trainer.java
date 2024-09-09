package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import java.util.List;


@Entity
@Table(name = "trainers")
public class Trainer extends User {

    private String specialization;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Schedule> available;

    public Trainer() {
        super();
    }

    public Trainer(int id, String name, String email, String password, String address, String phoneNumber, String role) {
        super(id,name,email,password,address,phoneNumber,role);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Schedule> getAvailable() {
        return available;
    }

    public void setAvailable(List<Schedule> available) {
        this.available = available;
    }

}
