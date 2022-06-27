package com.shusheng.config;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
public class QuartzNewBean extends QuartzJobBean {

    private static final Logger log = LoggerFactory.getLogger(QuartzNewBean.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        log.info("定时任务启动！");
    }
}
