package com.fitness.cs.fitness_project_be.model;
import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member extends User{

    private Date expireDate;
    private String memberType;

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