package com.shusheng.model.builder;

import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class MealBuilder {

    // 素食可乐套餐
    public Meal builderVegCoke(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    // 肉食咖啡套餐
    public Meal builderChickenPepsi(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
