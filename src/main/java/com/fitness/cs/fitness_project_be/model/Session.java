package com.fitness.cs.fitness_project_be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Session implements ISession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Session(){

    }

    public Session(long sessionId, Member member, Trainer trainer, Schedule dateSession, Program program,
            String status) {
        this.sessionId = sessionId;
        this.member = member;
        this.trainer = trainer;
        this.dateSession = dateSession;
        this.program = program;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule dateSession;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String status;

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Schedule getDateSession() {
        return dateSession;
    }

    public void setDateSession(Schedule dateSession) {
        this.dateSession = dateSession;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
