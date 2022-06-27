package com.shusheng.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/6/28.
 */
public class DateUtilDemo {
    public static void main(String[] args) {

        DateTime date = DateUtil.date();

        String dd = DateUtil.format(date, "dd");
        System.out.println("dd = " + dd);

        List<DateTime> dateTimes = DateUtil.rangeToList(DateUtil.parse("2021-12-28"), DateUtil.parse("2022-01-05"), DateField.DAY_OF_YEAR);

        List<String> dd1 = dateTimes.stream().map(x -> DateUtil.format(x, "dd") + "日达标数量").collect(Collectors.toList());

        System.out.println("dd1 = " + dd1);

        // 日期区间
        System.out.println("dateTimes = " + dateTimes);

        // 字符串转日期对象
        DateTime parse = DateUtil.parse("2021-12-25","yyyyMMdd", "yyyy-MM-dd");
        System.out.println("parse = " + parse);
        // 格式化日期
        String yyyyMMdd = DateUtil.format(parse, "yyyyMMdd");
        System.out.println("yyyyMMdd = " + yyyyMMdd);

        System.out.println("DateUtil.format(DateUtil.date(),\"yyyy年MM月dd日\") = " + DateUtil.format(DateUtil.date(), "yyyy年MM月dd日"));
    }
}
