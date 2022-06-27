package com.shusheng.demo;

import cn.hutool.core.io.FileUtil;

import java.util.Arrays;

/**
 * @author 刘闯
 * @date 2021/6/8.
 */
public class Demo {
    public static void main(String[] args) {
        byte[] bytes = FileUtil.readBytes("C:\\Users\\admin\\Desktop\\uTools_1631700182665.png");
        String s = Arrays.toString(bytes);
        System.out.println("s = " + s);
    }

}
