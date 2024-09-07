package com.fitness.cs.fitness_project_be.model;
import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Member extends User{

    Date expireDate;
    String memberType;

    public Member() {
        super();
    }

    public Member(int id, String name, String email, String address, String phoneNumber, Date expireDate, String memberType) {
        super(id, name, email, address, phoneNumber);
        this.expireDate = expireDate;
        this.memberType = memberType;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    
}