package com.shusheng.model.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐
 * @author 刘闯
 * @date 2021/6/30.
 */
public class Meal {
    private final List<Item> items = new ArrayList<>();

    // 添加类别
    public void addItem(Item item){
        items.add(item);
    }

    // 计算价格
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    // 显示订单
    public void showItems(){
        for (Item item : items) {
            System.out.println("item : " + item.name());
            System.out.println(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
