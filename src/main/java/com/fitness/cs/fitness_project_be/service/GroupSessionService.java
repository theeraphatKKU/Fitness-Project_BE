package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.GroupSession;
import com.fitness.cs.fitness_project_be.repository.GroupSessionRepository;

@Service
public class GroupSessionService {

    @Autowired
    private GroupSessionRepository groupSessionRepository;

    public List<GroupSession> getAllGroupSessions() {
        return groupSessionRepository.findAll();
    }

    public Optional<GroupSession> getGroupSessionById(int id) {
        return groupSessionRepository.findById(id);
    }

    public GroupSession createGroupSession(GroupSession groupSession) {
        return groupSessionRepository.save(groupSession);
    }

    public GroupSession updateGroupSession(int id, GroupSession updatedGroupSession) {
        Optional<GroupSession> existingGroupSession = groupSessionRepository.findById(id);
        if (existingGroupSession.isPresent()) {
            updatedGroupSession.setSessionId(id);
            return groupSessionRepository.save(updatedGroupSession);
        }
        return null; // Handle not found
    }

    public void deleteGroupSession(int id) {
        groupSessionRepository.deleteById(id);
    }
}
