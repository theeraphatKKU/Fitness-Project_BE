package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.Schedule;
import com.fitness.cs.fitness_project_be.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Get a schedule by ID
    public Optional<Schedule> getScheduleById(int id) {
        return scheduleRepository.findById(id);
    }

    // Create a new schedule
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Update a schedule
    public Schedule updateSchedule(int id, Schedule scheduleDetails) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(id);
        if (scheduleOptional.isPresent()) {
            Schedule schedule = scheduleOptional.get();
            schedule.setSdate(scheduleDetails.getSdate());
            schedule.setStartTime(scheduleDetails.getStartTime());
            schedule.setEndTime(scheduleDetails.getEndTime());
            schedule.setStatus(scheduleDetails.getStatus());
            return scheduleRepository.save(schedule);
        } else {
            throw new RuntimeException("Schedule not found with id " + id);
        }
    }

    // Delete a schedule by ID
    public void deleteScheduleById(int id) {
        scheduleRepository.deleteById(id);
    }
}
