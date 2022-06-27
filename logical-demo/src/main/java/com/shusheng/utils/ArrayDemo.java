package com.shusheng.utils;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组工具类
 * @author 刘闯
 * @date 2021/5/27.
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // 判断字符串中是否有空值
        List<String> list = new ArrayList<>();
        boolean notEmpty = ArrayUtil.isEmpty(list);
        System.out.println("notEmpty = " + notEmpty);
    }
}
