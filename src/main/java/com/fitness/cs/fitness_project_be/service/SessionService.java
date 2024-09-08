package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.Session;
import com.fitness.cs.fitness_project_be.repository.SessionRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(int id) {
        return sessionRepository.findById(id);
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session updateSession(int id, Session updatedSession) {
        Optional<Session> existingSession = sessionRepository.findById(id);
        if (existingSession.isPresent()) {
            updatedSession.setSessionId(id);
            return sessionRepository.save(updatedSession);
        }
        return null; // Handle not found
    }

    public void deleteSession(int id) {
        sessionRepository.deleteById(id);
    }
}
