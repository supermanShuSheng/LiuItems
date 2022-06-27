package com.shusheng.demo;

import java.util.Optional;

/**
 * @author 刘闯
 * @date 2021/7/28.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        String str =  null;
        String str1 = "123";
        String str11 = Optional.ofNullable(str).orElse("str1");


        System.out.println("str1 = " + str11);
    }
}
