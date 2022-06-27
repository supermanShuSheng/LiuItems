package com.shusheng.model.builder;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class BuilderTest {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        // 构建套餐2
        Meal meal = mealBuilder.builderChickenPepsi();

        System.out.println(" 构建套餐二 ");
        // 展示订单信息
        meal.showItems();
        // 展示价格
        System.out.println("Totel Cost: "+meal.getCost());
    }
}
