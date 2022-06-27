package com.shusheng.model.builder;

/**
 * 咖啡
 * @author 刘闯
 * @date 2021/6/30.
 */
public class Pepsi extends ColdDrink{
    // 名称
    @Override
    public String name() {
        return "咖啡";
    }
    // 价格
    @Override
    public float price() {
        return 4.0f;
    }
}
