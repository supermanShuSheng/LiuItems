package com.shusheng.task;

import cn.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author 刘闯
 * @date 2022/5/24
 */
@Component("taskLiuDemo")
public class TaskLiuDemo {


    private static final Logger log = LoggerFactory.getLogger(TaskLiuDemo.class);

    /**
     * 打印接收到的数据
     * @param jsonObject 接收数据
     */
    public void logLiuInfo(JSONObject jsonObject){
        log.info("执行了taskLiu的任务~");

        log.info("接收到的参数为：" + jsonObject);
    }
}
