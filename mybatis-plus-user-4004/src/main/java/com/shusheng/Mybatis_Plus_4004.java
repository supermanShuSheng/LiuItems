package com.shusheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.shusheng.mapper")
public class Mybatis_Plus_4004 {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis_Plus_4004.class, args);
    }

}
