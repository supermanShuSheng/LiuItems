package com.shusheng.model.builder;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public abstract class Burger implements Item{

    // 价格
    @Override
    public abstract float price();

    // 获取纸盒包装
    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
