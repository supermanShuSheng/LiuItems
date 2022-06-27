package com.shusheng.controller;

import cn.hutool.json.JSONObject;
import com.shusheng.mapper.SysLogBackMapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@RestController
@RequestMapping("/logback")
// @Slf4j
public class LiuDemoController {

    private static final Logger log = LoggerFactory.getLogger(LiuDemoController.class);

    @Autowired
    SysLogBackMapper sysLogBackMapper;

    /**
     * info 信息
     * @param message
     * @return
     */
    @RequestMapping("/info/{message}")
    public String sysInfoLog(@PathVariable String message){
        log.info(message);


        return "success";
    }

    /**
     * error 信息
     * @param message
     * @return
     */
    @RequestMapping("/error/{message}")
    public String sysErrorLog(@PathVariable String message){
        log.error(message);

        return "success";
    }

    /**
     * 测试logback日志信息
     * @param message
     * @return
     */
    @RequestMapping("/demoBack/{message}")
    public String demoBack(@PathVariable String message){
        log.error(message);

        List<JSONObject> jo = sysLogBackMapper.queryLogInfo();

        return "success";
    }

    /**
     * 测试logback日志信息
     * @param
     * @return
     */
    @RequestMapping("/demoBack1")
    public void demoBack1(@RequestBody Abc abc){
        System.out.println("abc = " + abc);
        abc.setType("123");
        System.out.println("abc = " + abc);


    }

    @Data
    public static class Abc {

        @Setter(AccessLevel.NONE)
        private String liuName = "1";

        private String liu;

        public void setLiuName(String liuName) {
//            this.liuName = "1";
        }

        private void setType(String type) {
            this.liuName = "567";
        }
    }
}
