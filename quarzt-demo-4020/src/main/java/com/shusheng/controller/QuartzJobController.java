package com.shusheng.controller;

import com.shusheng.entity.SysJob;
import com.shusheng.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2022/5/24
 */
@RestController
@RequestMapping("/quartz")
public class QuartzJobController {

    @Autowired
    QuartzJobService quartzJobService;

    /**
     * 添加一个定时任务
     * @param sysJob
     * @return
     */
    @PostMapping("/addJob")
    public String addQuartzJob(@RequestBody SysJob sysJob){
        return quartzJobService.addQuartzJob(sysJob);
    }

    /**
     * 执行某一个定时任务
     * @param sysJob
     * @return
     */
    @PostMapping("/runJob")
    public String runJob(@RequestBody SysJob sysJob){
        return quartzJobService.runJob(sysJob);
    }

    /**
     * 停止某一个定时任务
     * @param sysJob
     * @return
     */
    @PostMapping("/stopJob")
    public String stopJob(@RequestBody SysJob sysJob){
        return quartzJobService.stopJob(sysJob);
    }
}
