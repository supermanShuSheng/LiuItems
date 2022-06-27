package com.shusheng.serviceImpl;

import com.shusheng.commons.R;
import com.shusheng.entity.UserEntity;
import com.shusheng.mapper.UserMapper;
import com.shusheng.service.UserService;
import com.shusheng.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/6/4.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 通过ID获取用户对象
     * @param userId 用户ID
     * @return 用户对象
     */
    @Override
    public R<UserEntity> getUserById(String userId) {
        UserEntity userEntity = userMapper.getUserById(userId);

        return ResultUtils.determineData(userEntity, "该ID下无用户！");
    }

    /**
     * 用户进行登录验证
     * @param userName 用户名称
     * @param userPassword  用户密码
     */
    @Override
    public R checkUser(String userName, String userPassword) {
        UserEntity userEntity = userMapper.checkUser(userName, userPassword);
        if (userEntity == null){
            return ResultUtils.error("账号或密码错误！！");
        }

        return ResultUtils.success(userEntity, "登录成功！");
    }
}
