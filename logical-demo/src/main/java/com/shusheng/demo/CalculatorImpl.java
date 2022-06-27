package com.shusheng.demo;

/**
 * @author 刘闯
 * @date 2021/7/6.
 */
public class CalculatorImpl implements Calculator{

    //加
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    //减
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

}
