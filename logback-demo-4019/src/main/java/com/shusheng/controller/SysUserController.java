package com.shusheng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@RestController
@RequestMapping("/sysLog")
public class SysUserController {

    private static final Logger log =  LoggerFactory.getLogger("sys-user");

    @RequestMapping("/infoLog/{message}")
    public String getSysLog(@PathVariable String message){
        log.info(message, "登录成功！");

        return "success";
    }
}
