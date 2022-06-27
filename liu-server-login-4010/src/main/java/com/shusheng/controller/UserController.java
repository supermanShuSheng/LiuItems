package com.shusheng.controller;

import com.shusheng.commons.R;
import com.shusheng.entity.UserEntity;
import com.shusheng.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘闯
 * @date 2021/6/4.
 */

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 通过ID获取用户对象
     * @param userId  用户ID
     * @return  用户实体
     */
    @ApiOperation(value = "通过ID进行用户详细信息查询")
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public R<UserEntity> getUserInfo(@PathVariable("userId") String userId){
        return userService.getUserById(userId);
    }

    /**
     * 用户进行登录验证
     * @param userName 用户名称
     * @param userPassword  用户密码
     */
    @ApiOperation(value = "用户登录验证")
    @GetMapping(value = "/checkUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称"),
            @ApiImplicitParam(name = "userPassword", value = "用户密码")
    })
    public R checkUser(@RequestParam("userName") String userName,@RequestParam("userPassword") String userPassword) {
        return userService.checkUser(userName, userPassword);
    }
}
