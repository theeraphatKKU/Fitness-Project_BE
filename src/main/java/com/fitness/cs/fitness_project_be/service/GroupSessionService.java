package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.GroupSession;
import com.fitness.cs.fitness_project_be.model.Member;
import com.fitness.cs.fitness_project_be.repository.GroupSessionRepository;
import com.fitness.cs.fitness_project_be.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupSessionService {

    @Autowired
    private GroupSessionRepository groupSessionRepository;

    @Autowired
    private MemberRepository memberRepository;

    // Get all group sessions
    public List<GroupSession> getAllGroupSessions() {
        return groupSessionRepository.findAll();
    }

    // Get a group session by ID
    public Optional<GroupSession> getGroupSessionById(int id) {
        return groupSessionRepository.findById(id);
    }

    // Create a new group session
    public GroupSession createGroupSession(GroupSession groupSession) {
        return groupSessionRepository.save(groupSession);
    }

    // Update an existing group session
    public GroupSession updateGroupSession(int id, GroupSession updatedGroupSession) {
        Optional<GroupSession> existingGroupSession = groupSessionRepository.findById(id);
        if (existingGroupSession.isPresent()) {
            updatedGroupSession.setSessionId(id);
            return groupSessionRepository.save(updatedGroupSession);
        }
        return null; // Handle not found
    }

    // Delete a group session by ID
    public void deleteGroupSession(int id) {
        groupSessionRepository.deleteById(id);
    }

    public GroupSession addMembersToGroupSession(int sessionId, GroupSession groupSessionRequest) {
        // Fetch the existing GroupSession
        GroupSession existingSession = groupSessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found"));

        // Merge the new members into the existing members list without replacing the current ones
        List<Member> existingMembers = existingSession.getMembers();
        List<Member> newMembers = groupSessionRequest.getMembers();

        for (Member newMember : newMembers) {
            if (!existingMembers.contains(newMember)) {
                existingMembers.add(newMember); // Add only if the member is not already in the list
            }
        }

        // Update the rest of the fields
        existingSession.setProgram(groupSessionRequest.getProgram());
        existingSession.setDateSession(groupSessionRequest.getDateSession());
        existingSession.setTrainer(groupSessionRequest.getTrainer());
        existingSession.setStatus(groupSessionRequest.getStatus());

        // Save the updated GroupSession
        return groupSessionRepository.save(existingSession);
    }
}
