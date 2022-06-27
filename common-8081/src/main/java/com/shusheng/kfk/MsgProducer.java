package com.shusheng.kfk;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author 刘闯
 * @date 2021/7/20.
 */
@Component
//@EnableScheduling
public class MsgProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // 每10秒中发送一次
//    @Scheduled(cron = "0/10 * * * * ?")
    public void send() {
        // 生成ID
        String message = IdUtil.simpleUUID();

        ListenableFuture<SendResult<String, String>> simple = kafkaTemplate.send("simple", message);


        simple.addCallback(
                o -> System.out.println("消息发送成功！！"+ o),
                throwable -> System.out.println("消息发送失败,{}" + throwable.getMessage())
        );
    }
}
