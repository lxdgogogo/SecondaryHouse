package com.springboot.secondaryHouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.secondaryHouse.dao")
@SpringBootApplication
public class SecondaryHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondaryHouseApplication.class, args);
    }

}
