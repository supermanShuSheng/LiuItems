package com.shusheng.socket.interceptor;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/8/11.
 */
@Component
public class MyInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     *
     * @param request 请求头
     * @param response 相应头
     * @param wsHandler 连接
     * @param attributes  参数
     * @return true or false
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes){
        System.out.println("握手开始");
        // 获得请求参数
        Map<String, String> paramMap = HttpUtil.decodeParamMap(request.getURI().getQuery(), CharsetUtil.CHARSET_UTF_8);
        attributes.putAll(paramMap);

        return true;
    }

    /**
     * 握手后
     *
     * @param request 请求头
     * @param response 相应头
     * @param wsHandler  连接
     * @param exception  异常
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        System.out.println("握手完成");
    }

}
