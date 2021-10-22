package com.springboot.secondaryHouse.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-10-21 17:28:52
 */
public class User implements Serializable {
    private static final long serialVersionUID = 571827193108022453L;
    
    private String username;
    
    private String password;
    
    private String name;
    
    private String sex;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}