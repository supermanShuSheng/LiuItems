package com.shusheng.kfk;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author 刘闯
 * @date 2021/7/20.
 */

//@Component
public class KafkaSimpleConsumer {

    // 简单消费者
//    @KafkaListener(groupId = "simpleGroup", topics = "topic_input")
    public void consumer1_1(ConsumerRecord<String, Object> record) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("单独消费者消费消息 content = " + record.value());
    }
}
