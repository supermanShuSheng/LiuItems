package com.shusheng.domain;

import java.math.BigDecimal;

/**
 * @author 刘闯
 * @date 2021/2/5.
 */
public class Item {
    String name;
    int age;
    BigDecimal bigDecimal;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bigDecimal=" + bigDecimal +
                '}';
    }

    public Item() {
    }

    public Item(String name, int age, BigDecimal bigDecimal) {
        this.name = name;
        this.age = age;
        this.bigDecimal = bigDecimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }
}
