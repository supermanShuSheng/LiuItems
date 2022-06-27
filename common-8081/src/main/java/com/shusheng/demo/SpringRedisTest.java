package com.shusheng.demo;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.shusheng.utils.RedisUtils;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisTest {

    @Autowired
    RedisUtils redisUtils;

    @Value("${sms.channel}")
    private String channel;

    @Value("${sms.key}")
    private String key;

//    @Autowired
//    UserMapper userMapper;

    @Test
    public void demo(){
        redisUtils.set("liu","闯",60);
    }

    @Test
    public void demo1(){
        System.out.println("channel = " + channel);
        System.out.println("key = " + key);

        MsgEntity msgEntity = new MsgEntity();
        msgEntity.setPhone("18738470890");
        msgEntity.setMessage("哈哈哈!!！！");

        try {
            String str = Des3.encryptThreeDESECB(JSONObject.toJSONString(msgEntity), key);
            System.out.println("str = " + str);
            String post = HttpUtil.post("http://10.255.238.53:8888/message/sendMessage?messageInfo="+str+"&channel="+channel, "{}");

            System.out.println("post = " + post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo01(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("liu");
        List<String> list1 = null;
//        UserDo userDo = userMapper.queryUser(list1);
//        System.out.println("userDo = " + userDo);
    }

    @Data
    static class MsgEntity implements Serializable {
        private static final long serialVersionUID = -429772731704849700L;

        private String phone;
        private String message;
    }

}
