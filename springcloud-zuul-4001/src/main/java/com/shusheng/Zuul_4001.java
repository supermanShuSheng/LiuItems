package com.shusheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * EnableZuulProxy  开启zuul的功能
 * EnableDiscoveryClient   开机监听
 * @author 刘闯
 * @date 2021/3/19
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Zuul_4001 {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_4001.class, args);
    }

}
