package com.shusheng.config;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.List;

@Configuration
@EnableCaching
public class RedisCacheConfig {

    /**
     * 注册订阅通道
     * @param connectionFactory
     * @param messageListeners
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, List<MessageListener> messageListeners) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        for (MessageListener messageListener: messageListeners) {
            // 可以添加多个 messageListener，配置不同的交换机
            String topic = null;
            try {
                topic = ReflectUtil.getFieldValue(messageListener, "topic").toString();
            } catch (RuntimeException e) {
                throw new RuntimeException("订阅频道不能为空！");
            }

            container.addMessageListener(messageListener, new PatternTopic(topic));
        }
        return container;
    }

}
