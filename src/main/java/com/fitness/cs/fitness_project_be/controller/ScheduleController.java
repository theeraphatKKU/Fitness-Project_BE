package com.fitness.cs.fitness_project_be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.cs.fitness_project_be.model.Schedule;
import com.fitness.cs.fitness_project_be.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    
    @Autowired
    ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedule(){
        return new ResponseEntity<>(scheduleService.getAllSchedules(), HttpStatus.OK);
    }

    @GetMapping 
        public ResponseEntity<Optional<Schedule>> getScheduleById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(scheduleService.getScheduleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule newSchedule){
        return new ResponseEntity<>(scheduleService.createSchedule(newSchedule), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable("id") Integer id, @RequestBody Schedule updateSchedule){
        try{
            scheduleService.updateSchedule(id, updateSchedule);
            return ResponseEntity.status(404).body("Schedule ID: " + id + " has been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(404).body("Schedule not found with ID: " + id);
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") Integer id){
        try{
            scheduleService.deleteScheduleById(id);
            return ResponseEntity.ok("Schedule with ID: " + id + " has been deleted.");
        }catch (Exception e) {
            return ResponseEntity.status(404).body("Schedule not found with ID: " + id);
        }
    }
}
