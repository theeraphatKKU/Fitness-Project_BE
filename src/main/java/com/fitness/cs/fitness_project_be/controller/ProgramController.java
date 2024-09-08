package com.fitness.cs.fitness_project_be.controller;

import com.fitness.cs.fitness_project_be.model.Program;
import com.fitness.cs.fitness_project_be.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public Program getProgramById(@PathVariable int id) {
        return programService.getProgramById(id);
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.createProgram(program);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable int id, @RequestBody Program program) {
        return programService.updateProgram(id, program);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable int id) {
        programService.deleteProgram(id);
    }
}
