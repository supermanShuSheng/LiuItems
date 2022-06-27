package com.shusheng.service;

/**
 * @author 刘闯
 * @date 2021/9/22.
 */
public class TestDemo {
    public static void main(String[] args) {
        CCCCDDDD c = new CCCCDDDD("123");

        AAAABBB a = c;

        CCCCDDDD d = (CCCCDDDD) a;
        System.out.println("d = " + d.getAbc());
    }
}
