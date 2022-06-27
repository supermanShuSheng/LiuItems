package com.shusheng.strategy;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
@Service("p1")
public class P1 implements P{
    @Override
    public void getValue() {
        System.out.println(" 我是P1 ");
    }
}
