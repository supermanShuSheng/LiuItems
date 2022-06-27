package com.shusheng.quartzdemo;

import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author 刘闯
 * @date 2021/10/13.
 */
public class QuartzJob1 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(" 当前时间 "+ DateUtil.now());
    }

}
