package com.shusheng.controller.mynamedemo1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2021/3/19.
 */
@RestController
@RequestMapping("/demo2")
@Api(tags = "demo2管理")
public class Demo1Controller {


    /**
     * @param userName 条件
     * @return R
     */
    @ApiOperation(value = "查询用户信息", httpMethod = "GET")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(@RequestParam String userName){
        return userName;
    }



}
