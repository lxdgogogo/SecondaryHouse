package com.springboot.secondaryHouse.entity;

import lombok.Data;

@Data
public class UserInformation {
    private String username;

    private String name;

    private String sex;

    public UserInformation(User a){
        this.username = a.getUsername();
        this.name = a.getName();
        this.sex = a.getSex();
    }
}
