package com.springboot.secondaryHouse.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.secondaryHouse.entity.User;
import com.springboot.secondaryHouse.entity.UserInformation;
import com.springboot.secondaryHouse.entity.UserLogin;
import com.springboot.secondaryHouse.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-10-21 17:28:54
 */
@RestController
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param username 主键
     * @return 单条数据
     */
    @GetMapping("userInfo")
    public String selectUserInfo(@RequestBody String username) {
        User a = this.userService.queryById(username);
        UserInformation b = new UserInformation(a);
        return JSON.toJSONString(b);
    }

    @PostMapping("register")
    public String register(@RequestBody User user){
        userService.insert(user);
        return "success";
    }

    @PostMapping("login")
    public String login(@RequestBody UserLogin userLogin){
        User a = userService.queryById(userLogin.getUsername());
        if (a ==  null|| !Objects.equals(a.getPassword(), userLogin.getPassword()))
            return "failed";
        else
            return "success";
    }

}