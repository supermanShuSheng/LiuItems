package com.shusheng.socket.handler;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.shusheng.socket.manager.WsSessionManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author 刘闯
 * @date 2021/8/11.
 */
@Component
public class HttpAuthHandler extends TextWebSocketHandler {

    /**
     * socket 建立成功事件
     *
     * @param session  session值
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        // 用户连接成功，放入在线用户缓存
        String a = session.getAttributes().get("a").toString();
        WsSessionManager.add(a, session);
        // 当前连接数
        printConnectSize(a, "新建连接！");
    }

    /**
     * 接收消息事件
     *
     * @param session 会话
     * @param message 消息
     * @throws Exception 异常
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        String setPerson = session.getAttributes().get("a").toString();
        String getPerson = session.getAttributes().get("b").toString();

        // 接受者的session
        WebSocketSession webSocketSession = WsSessionManager.get(getPerson);
        if (webSocketSession != null){
            webSocketSession.sendMessage(new TextMessage(setPerson+"： 给您发送了一条消息\n   消息为：" + payload + " 时间为： " + DateUtil.now()));
            session.sendMessage(new TextMessage(getPerson + " 已接收到消息！"));
        }else {
            session.sendMessage(new TextMessage(getPerson+" 未构成连接！"));
        }
    }

    /**
     * socket 断开连接时
     *
     * @param session 会话
     * @param status 状态
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        String setPerson = session.getAttributes().get("a").toString();
        if (StringUtils.isNotBlank(setPerson)) {
            // 用户退出，移除缓存
            WsSessionManager.remove(setPerson);

            printConnectSize(setPerson, "退出连接！");
        }
    }


    /**
     * 输出当前连接数
     */
    public static void printConnectSize(){
        printConnectSize(null, null);
    }

    /**
     * 输出当前连接数相关信息
     */
    public static void printConnectSize(String user, String message){
        if (StrUtil.isAllNotEmpty(user, message)){
            System.out.println("用户 "+user+" "+ message);
        }
        System.out.println("当前连接数： " + WsSessionManager.getSocketConnSize());
    }

}
