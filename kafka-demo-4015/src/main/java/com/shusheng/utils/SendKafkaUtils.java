package com.shusheng.utils;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 发送Kafka数据信息
 * @author 刘闯
 * @date 2022/4/19.
 */
@Configuration
public class SendKafkaUtils {

    @Autowired
    private KafkaTemplate<String, String> template;


    /**
     * 发送数据到Kafka
     * @param json 发送数据 JSON格式
     * @param topic 频道
     */
    public void sendKafka(Object json, String topic){
        sendKafka(json, topic, null);
    }

    /**
     * 发送数据到Kafka
     * @param json 发送数据 JSON格式
     * @param topic 频道
     * @param partition 分区
     */
    public void sendKafka(Object json, String topic, Integer partition){
        String formatString = JSONObject.toJSONString(json);

        // 生成唯一的Key
        int key = formatString.hashCode();

        ListenableFuture<SendResult<String, String>> send = template.send(
                new ProducerRecord<>(topic, partition, String.valueOf(key), formatString)
        );

        // 进行回调 确认是否无异常
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            // 发送失败
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Kafka发送失败 ==> 失败时间为：" + DateUtil.now());
                System.out.println("失败原因为：" + throwable.getMessage());
            }

            // 发送成功
            @Override
            public void onSuccess(SendResult<String, String> result) {

            }
        });


    }
}
