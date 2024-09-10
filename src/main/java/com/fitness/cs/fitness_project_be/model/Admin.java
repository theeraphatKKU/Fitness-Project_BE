package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin extends User{
    
    // public Admin() {
    //     super();
    // }

    // public Admin(int id, String name, String email, String password, String address, String phoneNumber, String role) {
    //     super(id,name,email,password,address,phoneNumber,role);
    // }
}
