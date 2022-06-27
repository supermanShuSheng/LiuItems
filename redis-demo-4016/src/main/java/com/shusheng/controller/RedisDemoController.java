package com.shusheng.controller;

import com.shusheng.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * * @date 2022/4/21
 */
@RestController
public class RedisDemoController {

    @Autowired
    RedisUtils redisUtils;

    // 订阅频道
    @Value("${redisTopic}")
    private String redisTopic;

    /**
     * 设置普通String Redis
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/putRedis/{key}/{value}")
    public String setRedisString(@PathVariable String key, @PathVariable String value){
        redisUtils.set(key, value);

        // 设置5S失效
        redisUtils.set(key+"Time", value, 5);
        return "成功！";
    }

    /**
     * 获取普通Redis
     * @param key
     * @return
     */
    @GetMapping("/getRedis/{key}")
    public String getRedisString(@PathVariable String key){
        System.out.println(redisUtils.get(key));

        System.out.println(redisUtils.get(key + "Time"));
        return "成功！";
    }

    /**
     * 获取普通Redis
     * @param key
     * @return
     */
    @GetMapping("/getRedisSize/{key}")
    public String getRedisKeySize(@PathVariable String key){
        List<String> strs = initArray();

        String abc = "123";

        System.out.println(redisUtils.size(key));
        strs.forEach(System.out::println);
        System.out.println("abc = " + abc);
        return "成功！";
    }

    /**
     * 初始化数据信息
     * @return
     */
    private List<String> initArray() {
        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("edf");
        strs.add("obd");
        strs.add("plg");
        return strs;
    }

    // ================================================================================================


    /**
     * 设置HashSet Redis
     * @param key
     * @param maps
     * @return
     */
    @PostMapping("/putSetRedis/{key}")
    public String setRedisHashSet(@PathVariable String key, @RequestBody Map<String, Object> maps){
        redisUtils.hmset(key, maps);

        return "成功！";
    }

    /**
     * 设置HashSet Redis
     * @param key
     * @return
     */
    @GetMapping("/getSetRedis/{key}")
    public String getRedisHashSet(@PathVariable String key){
        System.out.println(redisUtils.hmget(key));

        return "成功！";
    }

    /**
     * 设置HashSet Redis
     * @param key
     * @return
     */
    @GetMapping("/putHashRedis/{key}/{item}/{val}")
    public String putHashRedis(@PathVariable String key, @PathVariable String item, @PathVariable String val){
        redisUtils.hset(key, item, val);

        return "成功！";
    }

    /**
     * 设置Set Redis
     * @param key
     * @return
     */
    @GetMapping("/putRedisSet/{key}/{item}")
    public String putRedisSet(@PathVariable String key, @PathVariable String... item){
        redisUtils.sSet(key, item);

        return "成功！";
    }

    /**
     * 设置List Redis
     * @param key
     * @return
     */
    @GetMapping("/putRedisList/{key}/{item}")
    public String putRedisList(@PathVariable String key, @PathVariable String... item){
        redisUtils.lSet(key, Arrays.asList(item));

        return "成功！";
    }

    //  ===================================================================

    /**
     * 对用户进行推送消息
     * @return
     */
    @GetMapping(value = "/sendToUserMessage/{message}")
    public String sendMessage(@PathVariable String message){
        redisUtils.convertAndSend(redisTopic, message);

        return "发送成功！";
    }
}
