package com.shusheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.shusheng.mapper"})
public class TkMybatis_4003 {

    public static void main(String[] args) {
        SpringApplication.run(TkMybatis_4003.class, args);
    }

}
