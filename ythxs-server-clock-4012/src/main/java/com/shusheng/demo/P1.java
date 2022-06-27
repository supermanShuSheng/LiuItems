package com.shusheng.demo;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/8/5.
 */
@Service("p1")
public class P1 extends P{

    @Override
    public String sayHear() {
        return "我是嘻嘻嘻~~~~";
    }

    @Override
    public String sayHello() {
        return "我是嘿嘿嘿~~~~";
    }

}
