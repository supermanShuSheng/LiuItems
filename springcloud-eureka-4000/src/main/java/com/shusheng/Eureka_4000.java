package com.shusheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka启动器
 * @author 刘闯
 * @date 2021/3/19
 */

@EnableEurekaServer
@SpringBootApplication
public class Eureka_4000 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_4000.class, args);
    }

}
