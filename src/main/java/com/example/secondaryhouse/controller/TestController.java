package com.example.secondaryhouse.controller;


import com.example.secondaryhouse.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(path = "/*", method = RequestMethod.POST)
    public String test(@RequestBody User user){
        return user.toString();
    }
}
