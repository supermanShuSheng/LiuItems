package com.shusheng.receive;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author  刘闯
 * redis订阅消息接收
 */
@Component("redisMsgReceiver")
public class RedisMsgReceiver implements MessageListener {

//    /**
//     * 该监听器订阅的是哪一个频道
//     */
//    @Value("${redisTopic}")
//    private String topic;

    /**
     * 该监听器订阅的是哪一个频道
     * 第二种方式
     */
    public static final String topic = "liu.shusheng";


    /**
     * 消息接收转发
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            String msg = new String(message.getBody(), StandardCharsets.UTF_8);

            System.out.println(" 接收到消息 " + msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
