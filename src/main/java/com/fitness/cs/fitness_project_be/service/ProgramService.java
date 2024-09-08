package com.fitness.cs.fitness_project_be.service;

import com.fitness.cs.fitness_project_be.model.Program;
import com.fitness.cs.fitness_project_be.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program getProgramById(int id) {
        Optional<Program> program = programRepository.findById(id);
        return program.orElse(null);
    }

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public Program updateProgram(int id, Program program) {
        if (programRepository.existsById(id)) {
            program.setProgramId(id); // Ensure the ID is set to the correct value
            return programRepository.save(program);
        }
        return null; // or throw an exception if preferred
    }

    public void deleteProgram(int id) {
        if (programRepository.existsById(id)) {
            programRepository.deleteById(id);
        }
    }
}
