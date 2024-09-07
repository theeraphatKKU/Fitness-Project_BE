package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer extends User {

    private String specialization;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Schedule> available;

    public Trainer() {
        super();
    }

    public Trainer(int id, String name, String email, String address, String phoneNumber, String specialization, List<Schedule> available) {
        super(id, name, email, address, phoneNumber);
        this.specialization = specialization;
        this.available = available;
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
