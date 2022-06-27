package com.shusheng.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

/**
 * @author 刘闯
 * @date 2021/5/8.
 */
public class RandomDemo {
    public static void main(String[] args) {
        System.out.println("IdUtil.randomUUID() = " + IdUtil.randomUUID());
        System.out.println("IdUtil.fastUUID() = " + IdUtil.fastUUID());
        System.out.println("IdUtil.simpleUUID() = " + IdUtil.simpleUUID());
        String str = "2021-02-03 15:46:56";
        String s = str.replaceAll("[[\\s-:punct:]]", "");
        Long long1 = Long.valueOf(s);
        System.out.println("long1 = " + long1);
        String format = DateUtil.format(DateUtil.date(), "yyyy-MM-dd");
        System.out.println("format = " + format);
        System.out.println("s = " + s);
    }
}
