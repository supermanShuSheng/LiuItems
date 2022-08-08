package com.shusheng.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2022/7/28
 */
public class DemoJdk {
    public static void main(String[] args) {
        String statDate = "2022-11-18";
        DateTime startDate = DateUtil.offsetDay(DateUtil.parse(statDate), -6);
        List<DateTime> dateTimes = DateUtil.rangeToList(startDate, DateUtil.parse(statDate), DateField.DAY_OF_YEAR);

        List<String> collect = dateTimes.stream().map(x -> {
            return DateUtil.format(x, "M月dd");
        }).collect(Collectors.toList());

        CollUtil.reverse(collect);

        System.out.println("dateTimes = " + collect);
    }
}
