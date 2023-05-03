package com.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.back.mapper")
public class BackApplication {

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(BackApplication.class, args);
    }

}
