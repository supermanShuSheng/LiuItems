package com.shusheng.future;

import cn.hutool.core.date.DateUtil;
import com.shusheng.domain.Do.UserDo;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
public class CompletableDemo implements Supplier<List<UserDo>> {

//    private final UserQueryDto userQueryDto;


    @Override
    public List<UserDo> get() {
        System.out.println(" 开启线程池UserDo === " + DateUtil.date());
//        List<UserDo> users = userMapper.getUsers(userQueryDto);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户查询完毕 === " + DateUtil.date());
        return null;
    }
}
