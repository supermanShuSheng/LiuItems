package com.shusheng.service;

import com.shusheng.entity.SysJob;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
public interface QuartzJobService {

    /**
     * 添加一个定时任务
     * @param sysJob
     * @return
     */
    String addQuartzJob(SysJob sysJob);

    /**
     * 执行某一个定时任务
     * @param sysJob
     * @return
     */
    String runJob(SysJob sysJob);

    /**
     * 停止某一个定时任务
     * @param sysJob
     * @return
     */
    String stopJob(SysJob sysJob);
}
