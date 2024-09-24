package com.fitness.cs.fitness_project_be.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class GroupSession implements ISession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;

    @ManyToMany
    @JoinTable(
        name = "group_session_member",
        joinColumns = @JoinColumn(name = "session_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    public GroupSession(long sessionId, List<Member> members, Trainer trainer, Schedule dateSession, Program program,
            String status) {
        this.sessionId = sessionId;
        this.members = members;
        this.trainer = trainer;
        this.dateSession = dateSession;
        this.program = program;
        this.status = status;
    }

    public GroupSession(){

    }

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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
