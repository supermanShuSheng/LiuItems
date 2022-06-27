package com.shusheng.socket.config;

import com.shusheng.socket.handler.HttpAuthHandler;
import com.shusheng.socket.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author 刘闯
 * @date 2021/8/11.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * 建立连接
     */
    @Autowired
    private HttpAuthHandler httpAuthHandler;

    /**
     * 握手拦截器
     */
    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * ws://127.0.0.1:4011/myWS
     * addHandler 第一个参数 连接器  第二个参数暴露接口
     * @param registry 暴露接口
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(httpAuthHandler, "myWS")
                .addInterceptors(myInterceptor)
                .setAllowedOrigins("*");
    }
}


