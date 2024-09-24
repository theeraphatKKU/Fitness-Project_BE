package com.fitness.cs.fitness_project_be.controller;

import com.fitness.cs.fitness_project_be.model.GroupSession;
import com.fitness.cs.fitness_project_be.service.GroupSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupsessions")
public class GroupSessionController {

    @Autowired
    private GroupSessionService groupSessionService;

    @GetMapping
    public List<GroupSession> getAllGroupSessions() {
        return groupSessionService.getAllGroupSessions();
    }

    @GetMapping("/{id}")
    public Optional<GroupSession> getGroupSessionById(@PathVariable int id) {
        return groupSessionService.getGroupSessionById(id);
    }

    @PostMapping
    public GroupSession createGroupSession(@RequestBody GroupSession groupSession) {
        return groupSessionService.createGroupSession(groupSession);
    }

    @PutMapping("/{id}")
    public GroupSession updateGroupSession(@PathVariable int id, @RequestBody GroupSession groupSession) {
        return groupSessionService.updateGroupSession(id, groupSession);
    }

    @DeleteMapping("/{id}")
    public void deleteGroupSession(@PathVariable int id) {
        groupSessionService.deleteGroupSession(id);
    }
    @PutMapping("/addMember/{id}")
    public GroupSession addMembersToGroupSession(@PathVariable int id, @RequestBody GroupSession groupSessionRequest) {
        return groupSessionService.addMembersToGroupSession(id, groupSessionRequest);
    }
    
}
