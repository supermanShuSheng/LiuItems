package com.shusheng.model.builder;

/**
 * 炸鸡汉堡
 * @author 刘闯
 * @date 2021/6/30.
 */
public class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "炸鸡汉堡";
    }

    @Override
    public float price() {
        return 40.0F;
    }
}
