package com.shusheng.demo;


import cn.hutool.core.io.FileUtil;

/**
 * @author 刘闯
 * @date 2022/6/27
 */
public class DemoFenZhi {

    public static void main(String[] args) {
        String str = "mainName.jpg";
        String s = FileUtil.mainName(str);
        System.out.println("s = " + s);


    }
}
