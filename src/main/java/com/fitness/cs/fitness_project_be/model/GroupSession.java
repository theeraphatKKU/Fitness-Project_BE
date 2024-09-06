package com.fitness.cs.fitness_project_be.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class GroupSession implements ISession{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long sessionId;
    @OneToMany
    List<Member> member;
    Trainer trainer;
    Scheduler dateSession;
    Program program;
    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void scheduleSession() {
        System.out.println("Session started");
    }

    @Override
    public void cancelSession() {
        System.out.println("Session Canceled");
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Scheduler getDateSession() {
        return dateSession;
    }

    public void setDateSession(Scheduler dateSession) {
        this.dateSession = dateSession;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    
}
