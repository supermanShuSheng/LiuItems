package com.shusheng.serviceImpl;

import cn.hutool.core.date.DateUtil;
import com.shusheng.constant.ScheduleConstants;
import com.shusheng.entity.SysJob;
import com.shusheng.service.QuartzJobService;
import com.shusheng.utils.ScheduleUtils;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

    final Scheduler scheduler;

    public QuartzJobServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * 添加一个定时任务
     * @param sysJob
     * @return
     */
    @Override
    public String addQuartzJob(SysJob sysJob) {
        Date jobDate = sysJob.getJobDate();
        String cron = DateUtil.format(jobDate, "ss mm HH dd MM ? yyyy");
        sysJob.setCronExpression(cron);

        // 开启一个定时任务
        ScheduleUtils.createScheduleJob(scheduler, sysJob);

        return "success";
    }

    /**
     * 执行某一个定时任务
     * @param sysJob
     * @return
     */
    @Override
    public String runJob(SysJob sysJob) {
        Long jobId = sysJob.getJobId();
        String jobGroup = sysJob.getJobGroup();

        // 参数
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(ScheduleConstants.TASK_PROPERTIES, sysJob);
        try {
            scheduler.triggerJob(ScheduleUtils.getJobKey(jobId, jobGroup), dataMap);
        } catch (SchedulerException e) {
            return "error";
        }

        return "success";
    }

    /**
     * 停止某一个定时任务
     * @param sysJob
     * @return
     */
    @Override
    public String stopJob(SysJob sysJob) {
        // 暂停任务
//        scheduler.pauseJob(ScheduleUtils.getJobKey(jobId, jobGroup));
        // 恢复任务
//        scheduler.resumeJob(ScheduleUtils.getJobKey(jobId, jobGroup));
        // 删除任务
//        scheduler.deleteJob(ScheduleUtils.getJobKey(jobId, jobGroup));
        // 是否存在任务
//        scheduler.checkExists(ScheduleUtils.getJobKey(jobId, jobGroup));
        // 清空
//        scheduler.clear();
        return null;
    }


}
