package com.springboot.secondaryHouse;

import com.springboot.secondaryHouse.entity.User;
import com.springboot.secondaryHouse.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SecondaryHouseApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//        List<User> a = userService.test();
//        System.out.println(a);
    }

}
