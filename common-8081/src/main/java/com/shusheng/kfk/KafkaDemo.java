package com.shusheng.kfk;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/7/20.
 */
@Component
@EnableScheduling
public class KafkaDemo {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // 每10秒中发送一次
//    @Scheduled(cron = "0 * * * * ?")
    public void sendMessage(){
        for (int i = 0; i < 10; i++) {
            final int k = i;
            new Thread(() -> {
                String uuid = IdUtil.simpleUUID();
                System.out.println("发送第" + k + "条消息 ===== " + uuid);
                kafkaTemplate.send("topic_input", "刘"+k+"：" + IdUtil.simpleUUID());
            }).start();
        }
    }

    /**
     * 监听
     * @param msg 消息
     */
//    @KafkaListener(groupId = "simpleGroup", topics = "topic_input")
    public void kafkaListen(String msg) throws InterruptedException {
        System.out.println("接收消息为:  "+msg);
        Thread.sleep(1000);
    }
}
