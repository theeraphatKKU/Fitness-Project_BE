package com.fitness.cs.fitness_project_be.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member extends User{

    private Date expireDate;
    private String memberType;

    // public Member() {
    //     super();
    // }

    // public Member(int id, String name, String email, String password, String address, String phoneNumber, String role) {
    //     super(id,name,email,password,address,phoneNumber,role);
    // }

    // public Date getExpireDate() {
    //     return expireDate;
    // }

    // public void setExpireDate(Date expireDate) {
    //     this.expireDate = expireDate;
    // }

    // public String getMemberType() {
    //     return memberType;
    // }

    // public void setMemberType(String memberType) {
    //     this.memberType = memberType;
    // }
    
}