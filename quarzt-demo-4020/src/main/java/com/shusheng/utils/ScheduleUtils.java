package com.shusheng.utils;

import com.shusheng.constant.ScheduleConstants;
import com.shusheng.entity.SysJob;
import org.quartz.*;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
public class ScheduleUtils {


    /**
     * 创建定时任务
     * @param scheduler  调度器
     * @param job 任务
     */
    public static void createScheduleJob(Scheduler scheduler, SysJob job) {
        Class<? extends Job> jobClass = QuartzJobExecution.class;
        // 构建job信息
        Long jobId = job.getJobId();
        String jobGroup = job.getJobGroup();

        // 构建执行的任务
        // 1. 构建的Key值
        JobKey jobKey = getJobKey(jobId, jobGroup);
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobKey).build();

        // 放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(ScheduleConstants.TASK_PROPERTIES, job);

        // 表达式调度构建器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
        cronScheduleBuilder = handleCronScheduleMisfirePolicy(job.getMisfirePolicy(), cronScheduleBuilder);

        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                // 要执行的任务
                .withIdentity(getTriggerKey(jobId, jobGroup))
                // 使用的调度器
                .withSchedule(cronScheduleBuilder).build();

        // 判断是否存在
        try {
            if (scheduler.checkExists(jobKey)) {
                // 防止创建时存在数据问题 先移除，然后在执行创建操作
                scheduler.deleteJob(jobKey);
            }
            // 创建任务
            scheduler.scheduleJob(jobDetail, trigger);

            // 暂停任务
            if (job.getStatus().equals("1")) {
                scheduler.pauseJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Key
     * @param jobId 任务ID
     * @param jobGroup 任务组
     * @return key
     */
    private static TriggerKey getTriggerKey(Long jobId, String jobGroup) {
        return TriggerKey.triggerKey(ScheduleConstants.TASK_PROPERTIES + jobId, jobGroup);
    }

    /**
     * 定时任务执行的策略
     * @param misfirePolicy 策略
     * @param cronScheduleBuilder 调度器
     * @return 执行策略
     */
    private static CronScheduleBuilder handleCronScheduleMisfirePolicy(String misfirePolicy, CronScheduleBuilder cronScheduleBuilder) {
        switch (misfirePolicy)
        {
            case "0":  // 默认
                return cronScheduleBuilder;
            case "1":  // 以错过的第一个频率时间立刻开始执行，重做错过的所有频率周期后，当下一次触发频率发生时间大于当前时间后，再按照正常的Cron频率依次执行
                return cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
            case "2":  // 以当前时间为触发频率立刻触发一次执行，然后按照Cron频率依次执行
                return cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
            case "3":  // 不触发立即执行，等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
                return cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
            default:
                throw new RuntimeException("未找到合适的调度器！");
        }
    }

    /**
     * 构建任务Key
     * @param jobId 任务ID
     * @param jobGroup 任务组
     * @return key
     */
    public static JobKey getJobKey(Long jobId, String jobGroup) {
        return JobKey.jobKey(ScheduleConstants.TASK_PROPERTIES + jobId, jobGroup);
    }
}
