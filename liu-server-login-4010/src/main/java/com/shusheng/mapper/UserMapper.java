package com.shusheng.mapper;

import com.shusheng.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 刘闯
 * @date 2021/6/4.
 */

@Repository
public interface UserMapper {

    /**
     * 通过ID获取用户对象
     * @param userId 用户ID
     * @return 用户对象
     */
    UserEntity getUserById(@Param("userId") String userId);

    /**
     * 用户进行登录验证
     * @param userName 用户名称
     * @param userPassword  用户密码
     */
    UserEntity checkUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
