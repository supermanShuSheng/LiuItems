package com.shusheng.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 集合工具
 * @author 刘闯
 * @date 2021/5/27.
 */
public class CollUtilDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","abc","eee");
         // list 转字符串 在拼接时进行组装
        String s = list.toString();
        System.out.println("s = " + s);
        String join = CollUtil.join(list,"");
        System.out.println("join = " + join);
        // 判断list是否有空值
        boolean empty = CollUtil.isEmpty(list);
        System.out.println("empty = " + empty);
    }
}
