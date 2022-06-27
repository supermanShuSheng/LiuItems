package com.shusheng.entity;

import lombok.Data;

import java.util.Date;

/**
 * 定时任务调度表 sys_job
 * 
 * @author ruoyi
 */
@Data
public class SysJob {

    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long jobId;

    /** 任务名称 */
    private String jobName;

    /** 任务组名 */
    private String jobGroup;

    /** 调用目标字符串 */
    private String invokeTarget;

    /** cron执行表达式 */
    private String cronExpression;

    /** cron计划策略 1=立即触发执行,2=触发一次执行,3=不触发立即执行*/
    private String misfirePolicy = "1";

    /** 是否并发执行（0允许 1禁止） */
    private String concurrent;

    /** 任务状态（0正常 1暂停） */
    private String status = "0";

    /** 执行日期 */
    private Date jobDate;
}
