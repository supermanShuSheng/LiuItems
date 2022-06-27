package com.shusheng.model.builder;

/**
 * 素汉堡
 * @author 刘闯
 * @date 2021/6/30.
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "素食汉堡";
    }

    @Override
    public float price() {
        return 25.0F;
    }
}
