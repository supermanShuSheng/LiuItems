package com.shusheng.demo;

/**
 * @author 刘闯
 * @date 2021/6/18.
 */
public class NeiBuDemo {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa.setAaaAge("18");
        aaa.setAaaName("liu");
        AAA.BBB bbb = new AAA().new BBB();
        bbb.setBbbAge("123");
        bbb.setBbbName("chuang");

        aaa.setBbb(bbb);
        System.out.println("aaa = " + aaa);
    }
}
