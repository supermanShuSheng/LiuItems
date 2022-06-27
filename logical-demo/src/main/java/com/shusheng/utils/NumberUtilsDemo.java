package com.shusheng.utils;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**
 * @author 刘闯
 * @date 2021/5/27.
 */
public class NumberUtilsDemo {
    public static void main(String[] args) {
        // 小数的加减
        double a1 = 123.456;
        double b1 = 123.455;
        System.out.println("(a1-b1) = " + (a1-b1));
        // 利用工具类
        double sub = NumberUtil.sub(a1, b1);
        System.out.println("sub = " + sub);
        // 保留小数
        double c1 = 2312313.4158961650000;
        BigDecimal round = NumberUtil.round(c1, 3);
        System.out.println("round = " + round);
        String s = NumberUtil.roundStr(c1, 5);
        System.out.println("s = " + s);

        // 数据格式化 光速 转化为  。###
        double d1 = 1234567890;
        String format = NumberUtil.decimalFormat(",###", d1);
        System.out.println("format = " + format);
    }
}
