package com.shusheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author 刘闯
 * @date 2021/3/19
 */
@MapperScan("com.shusheng.mapper")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class Docs_4011 {

    public static void main(String[] args) {
        SpringApplication.run(Docs_4011.class, args);
    }

}
