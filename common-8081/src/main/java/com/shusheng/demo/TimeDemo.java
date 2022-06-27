package com.shusheng.demo;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 动态定时任务
 * @author 刘闯
 * @date 2021/7/9.
 */

//@Configuration      //1.主要用于标记配置类，兼备Component的效果
//@EnableScheduling   //2.开启定时任务
public class TimeDemo implements SchedulingConfigurer {



    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(
//                // 添加任务
//                 () -> System.out.println(" 123 "+userService.getUsersById("root"))
//                 , triggerContext -> new CronTrigger("*/5 * * * * ?").nextExecutionTime(triggerContext));
    }
}
