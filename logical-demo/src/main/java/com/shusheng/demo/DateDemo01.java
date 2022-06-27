package com.shusheng.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author 刘闯
 * @date 2021/8/27.
 */
public class DateDemo01 {
    public static void main(String[] args) {
        DateTime parse = DateUtil.parse("2021-08-02", "yyyy-MM-dd");
        int i = DateUtil.weekOfMonth(parse);
        System.out.println("i = " + i);

        DateTime yyyy = DateUtil.endOfYear(DateUtil.parse("2021", "yyyy"));
        System.out.println("yyyy = " + yyyy);

        Date date = new Date("Mon Aug 02 2021 00:00:00 GMT+0800 (中国标准时间)");
        System.out.println("date = " + date);

        String format = DateUtil.format(date, "yyyy-MM-dd");
        System.out.println("format = " + format);

        DateTime start = DateUtil.beginOfWeek(DateUtil.parse("2012-01-01", "yyyy-MM-dd"));

        DateTime end = DateUtil.offsetDay(start, 6);

        System.out.println(start + " ===== " + end);
    }
}
