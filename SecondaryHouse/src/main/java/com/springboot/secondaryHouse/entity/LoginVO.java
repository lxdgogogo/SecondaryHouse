package com.springboot.secondaryHouse.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginVO implements Serializable {
    private String username;
    private String token;
    private User user;
}
