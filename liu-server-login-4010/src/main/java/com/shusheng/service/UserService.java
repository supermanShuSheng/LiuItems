package com.shusheng.service;

import com.shusheng.commons.R;
import com.shusheng.entity.UserEntity;

/**
 * @author 刘闯
 * @date 2021/6/4.
 */

public interface UserService {
    /**
     * 通过ID获取用户对象
     * @param userId 用户ID
     * @return 用户对象
     */
    R<UserEntity> getUserById(String userId);

    /**
     * 用户进行登录验证
     * @param userName 用户名称
     * @param userPassword  用户密码
     */
    R checkUser(String userName, String userPassword);
}
