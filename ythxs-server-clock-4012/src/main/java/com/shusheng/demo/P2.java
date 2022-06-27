package com.shusheng.demo;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/8/5.
 */
@Service("p2")
public class P2 extends P{

    @Override
    public String sayHello() {
        return "我是哈哈哈~~~~";
    }

}
