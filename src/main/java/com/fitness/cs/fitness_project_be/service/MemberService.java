package com.fitness.cs.fitness_project_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.cs.fitness_project_be.model.Member;
import com.fitness.cs.fitness_project_be.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(int id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(int id, Member updatedMember) {
        Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {
            return memberRepository.save(updatedMember);
        }
        return null; // Handle not found
    }

    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
