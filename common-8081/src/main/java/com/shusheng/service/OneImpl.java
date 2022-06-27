package com.shusheng.service;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/7/5.
 */
@Service(value = "oneImpl")
public class OneImpl implements TestStrategyService{



//    final UserMapper userMapper;
//
//    public OneImpl(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Override
    public void sayLoves() {
        System.out.println(" One ");
    }

}
