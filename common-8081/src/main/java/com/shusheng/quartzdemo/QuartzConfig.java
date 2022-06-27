package com.shusheng.quartzdemo;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘闯
 * @date 2021/10/13.
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail1(){
        return JobBuilder.newJob(QuartzJob1.class).
                withIdentity("myJob1", "myJobGroup1").  // 分组
                usingJobData("param","value").   // 传递参数
                storeDurably().build();
    }

    @Bean
    public Trigger trigger1(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10) //每一秒执行一次
                .repeatForever(); //永久重复，一直执行下去


//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");

        return TriggerBuilder.newTrigger() // 触发器
                .forJob(jobDetail1())  // 关联工作
                .withSchedule(scheduleBuilder)  //  定时控制
                .build();
    }

}
