package com.fitness.cs.fitness_project_be.controller;

import com.fitness.cs.fitness_project_be.model.Member;
import com.fitness.cs.fitness_project_be.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MEMBER')")
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MEMBER')")
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MEMBER')")
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MEMBER')")
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
    }
}
