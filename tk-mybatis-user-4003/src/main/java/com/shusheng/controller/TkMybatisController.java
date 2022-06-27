package com.shusheng.controller;

import com.shusheng.entity.UserRole;
import com.shusheng.mapper.UserRoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘闯
 * @date 2021/8/12.
 */
@RestController
@Api(value = "测试TkMybatis")
public class TkMybatisController {

    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * 插入用户
     * @param userRole 用户
     */
    @PostMapping("/insertUser")
    @ApiModelProperty(value = "插入用户通过TkMybatis")
    public String insertUser(@RequestBody UserRole userRole){
        int insert = userRoleMapper.insert(userRole);
        System.out.println("插入成功 ： " + insert);
        return "成功！";
    }
}
