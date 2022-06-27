package com.shusheng.model.strategy;

import org.springframework.stereotype.Service;

/**
 * @author 刘闯
 * @date 2021/7/19.
 */
@Service("p2")
public class P2 implements P{
    @Override
    public void getValue() {
        System.out.println(" 我是P2 ");
    }
}
