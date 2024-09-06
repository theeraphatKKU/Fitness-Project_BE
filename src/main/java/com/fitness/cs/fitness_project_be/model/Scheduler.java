package com.fitness.cs.fitness_project_be.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Scheduler implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int scheduleId;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public Scheduler(int id,DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time cannot be after end time.");
        }
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlapsWith(Scheduler other) {
        return this.dayOfWeek == other.dayOfWeek &&
               !this.endTime.isBefore(other.startTime) &&
               !this.startTime.isAfter(other.endTime);
    }

    @Override
    public String toString() {
        return "Schedule: " + dayOfWeek + " from " + startTime + " to " + endTime;
    }
}
