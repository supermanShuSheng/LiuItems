package com.shusheng.model.builder;

/**
 * 可乐
 * @author 刘闯
 * @date 2021/6/30.
 */
public class Coke extends ColdDrink{
    // 名称
    @Override
    public String name() {
        return "可乐";
    }
    // 价格
    @Override
    public float price() {
        return 5.0f;
    }
}
