package com.shusheng.demo;

import cn.hutool.core.lang.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/8/16.
 */
@Component
public class ApplicUtil {

    @Autowired
    private ApplicationContext applicationContext;

    public void getUser(){
        Dict dict = new Dict();
//        UserMapper bean = applicationContext.getBean(UserMapper.class);
    }
}
