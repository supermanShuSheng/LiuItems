package com.shusheng.hutool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author 刘闯
 * @date 2021/6/7.
 */
public class DateUtilDemo {
    public static void main(String[] args) throws InterruptedException {
        // 测试日期
        DateTime date = DateUtil.date();
        System.out.println("date = " + date);
        Thread.sleep(2000);
        DateTime date1 = DateUtil.date();
        System.out.println("date1 = " + date1);
        long l = DateUtil.compare(date1, date);
        System.out.println("l = " + l);
    }
}
