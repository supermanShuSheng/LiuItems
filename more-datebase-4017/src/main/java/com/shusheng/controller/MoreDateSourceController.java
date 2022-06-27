package com.shusheng.controller;

import cn.hutool.json.JSONObject;
import com.shusheng.mapper.db1.MoreDb1Mapper;
import com.shusheng.mapper.db2.MoreDb2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/23
 */
@RestController
@RequestMapping("/more")
public class MoreDateSourceController {

    @Autowired
    MoreDb1Mapper moreDb1Mapper;

    @Autowired
    MoreDb2Mapper moreDb2Mapper;

    /**
     * 查询本地数据
     * @return
     */
    @RequestMapping("/db1")
    public String getDb1Data(){
        List<JSONObject> jo = moreDb1Mapper.getUserInfo();

        System.out.println("jo = " + jo);

        return "success";
    }

    /**
     * 查询服务器数据
     * @return
     */
    @RequestMapping("/db2")
    public String getDb2Data(){
        List<JSONObject> jo = moreDb2Mapper.getTranInfo();

        System.out.println("jo = " + jo);

        return "success";
    }
}
