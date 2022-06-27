package com.shusheng.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2022/4/20.
 */
@Component
public class ConsumeExecute {

    /**
     * 监听信息
     * @param record
     */
    @KafkaListener(topicPartitions = {
        @TopicPartition(topic = "liu.info.message", partitions = {"1", "2", "3"})
    })
    public void consumeMessage(ConsumerRecord<Integer, String> record){
        String value = record.value();

        System.out.println(" 我是分组One 收到了"+ record.partition() +"分区的信息 ==> " + value);
    }

    /**
     * 监听信息
     * @param record
     */
    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "liu.info.message", partitions = {"3","4"})
    })
    public void consumeMessage1(ConsumerRecord<Integer, String> record){
        String value = record.value();

        System.out.println(" 我是分组Two 收到了"+ record.partition() +"分区的信息 ==> " + value);
    }


    /**
     * 监听信息
     * @param record
     */
    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "liu.info.message", partitions = {"0", "1"})
    })
    public void consumeMessage2(ConsumerRecord<Integer, String> record){
        String value = record.value();

        System.out.println(" 我是分组Three 收到了"+ record.partition() +"分区的信息 ==> " + value);
    }
}
