package com.shusheng.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘闯
 * @date 2022/5/24
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(QuartzNewBean.class)
                // 指定任务的名称
                .withIdentity("quartzNewBean")
                // 任务描述
                .withDescription("任务描述：用于输出冬奥欢迎语")
                // 每次任务执行后进行存储
                .storeDurably()
                // 创建
                .build();
    }

    @Bean
    public Trigger trigger() {
        //创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .forJob(jobDetail())
                // 每隔 5 秒执行一次 job
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();
    }

}
