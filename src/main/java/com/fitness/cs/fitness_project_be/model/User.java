package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.InheritanceType;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Set<String> roles;

    // public User() {
    //     this.id = 0;
    //     this.name = "";
    //     this.email = "";
    //     this.password = "";
    //     this.address = "";
    //     this.phoneNumber = "";
    //     this.role = "";
    // }

    // public User(int id, String name, String email, String password, String address, String phoneNumber, String role) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    //     this.address = address;
    //     this.phoneNumber = phoneNumber;
    // }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getPassword(){
    //     return this.password;
    // }

    // public void setPassword(String password){
    //     this.password = password;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public String getPhoneNumber() {
    //     return phoneNumber;
    // }

    // public void setPhoneNumber(String phoneNumber) {
    //     this.phoneNumber = phoneNumber;
    // }

    // public String getRole(){
    //     return this.role;
    // }

    // public void setRole(String role){
    //     this.role = role;
    // }

}