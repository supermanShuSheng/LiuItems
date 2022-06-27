package com.shusheng.future;

import cn.hutool.core.date.DateUtil;
import com.shusheng.domain.Do.UserDo;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
public class FutureDemo implements Callable<List<UserDo>> {

//    private final UserQueryDto userQueryDto;
//
////    private final UserMapper userMapper;
//
//    public FutureDemo(UserQueryDto userQueryDto,UserMapper userMapper) {
//        this.userQueryDto = userQueryDto;
//        this.userMapper = userMapper;
//    }

    @Override
    public List<UserDo> call(){
        System.out.println(" 开启线程池UserDo === " + DateUtil.date());
//        List<UserDo> users = userMapper.getUsers(userQueryDto);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户查询完毕 === " + DateUtil.date());
        return null;
    }
}
