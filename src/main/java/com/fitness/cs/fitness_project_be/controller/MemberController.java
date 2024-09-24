package com.fitness.cs.fitness_project_be.controller;

import java.util.stream.Collectors;

import com.fitness.cs.fitness_project_be.model.Member;
import com.fitness.cs.fitness_project_be.model.UserRole;
import com.fitness.cs.fitness_project_be.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('MEMBER') ")
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/onlyuser")
    public ResponseEntity<List<Member>> getOnlyUsers() {
    List<Member> users = memberService.getAllMembers();
    List<Member> filteredUsers = users.stream()
                                    .filter(user -> user.getRole() == UserRole.USER)
                                    .collect(Collectors.toList());
    return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberService.createMember(member);
    }

    // @PostMapping
    // public ResponseEntity<Member> updateMemberDetails(@RequestBody Member member) {
    //     Member updatedMember = memberService.createMember(member);
    //     updatedMember.setPassword(passwordEncoder.encode(updatedMember.getPassword()));
    //     return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    // }

    
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member member) {
        
        return memberService.updateMember(id, member);
    }

    
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
    }
}
