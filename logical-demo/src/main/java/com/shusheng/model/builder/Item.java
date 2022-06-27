package com.shusheng.model.builder;

import java.util.stream.Stream;

/**
 * 组
 * @author 刘闯
 * @date 2021/6/30.
 */
public interface Item {
    // 获取名称
    public String name();
    // 获取价格
    public float price();
    // 获取包装
    public Packing packing();
}
