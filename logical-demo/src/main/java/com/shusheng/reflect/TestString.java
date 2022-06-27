package com.shusheng.reflect;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class TestString {
    public static void main(String[] args) {
        String str = "001";
        int i = Integer.parseInt(str);
        System.out.println("i = " + i);
        String format = String.format("%03d", i);
        System.out.println("format = " + format);
    }
}
