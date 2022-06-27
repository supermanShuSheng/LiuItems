package com.shusheng;

import cn.dev33.satoken.SaManager;
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
//@EnableScheduling //开启定时任务
public class Common_8081 {

    public static void main(String[] args) {
        SpringApplication.run(Common_8081.class, args);
        System.out.println("启动成功：sa-token配置如下：" + SaManager.getConfig());
    }

}
