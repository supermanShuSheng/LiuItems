package com.shusheng.controller;

import com.shusheng.annotations.Log;
import com.shusheng.mapper.DemoConnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@RestController
@RequestMapping("/conn")
public class DemoConnController {

    @Autowired
    DemoConnMapper demoConnMapper;

    @Log(title = "测试一")
    @RequestMapping("/getTranNumber")
    public Integer getTranNumber(){
        System.out.println("demoConnMapper = ");
        return demoConnMapper.getTranNumber();
    }
}
