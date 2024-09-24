package com.fitness.cs.fitness_project_be.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Program {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int programId;
    String programName;
    String description;
    String programType;

    public Program(){

    }

    public Program(int programId,String programName, String description, String programType) {
        this.programId = programId;
        this.programName = programName;
        this.description = description;
        this.programType = programType;
    }

    public Program(int programId) {
        this.programId = programId;
    }
    

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }


    public int getProgramId() {
        return programId;
    }


    public void setProgramId(int programId) {
        this.programId = programId;
    }
    
    
    
}