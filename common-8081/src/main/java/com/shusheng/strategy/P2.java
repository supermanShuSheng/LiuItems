package com.shusheng.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
@Service("p2")
public class P2 implements P{

//    @Autowired
//    UserMapper userMapper;

    @Override
    public void getValue() {
//        System.out.println(" =============== "+userMapper);
        System.out.println(" 我是P2 ");
    }
}
