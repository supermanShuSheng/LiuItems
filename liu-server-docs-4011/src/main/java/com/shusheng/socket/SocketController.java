package com.shusheng.socket;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

/**
 * @author 刘闯
 * @date 2021/8/11.
 */

@Component
public class SocketController {

    public void getSocketMessage(@Param("str") String str){

    }

}
