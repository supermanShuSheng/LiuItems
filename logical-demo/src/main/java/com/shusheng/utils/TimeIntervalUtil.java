package com.shusheng.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class TimeIntervalUtil {
    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("花费秒数 = " + timer.intervalSecond());
        System.out.println("返回花费时间，并重置开始时间 "+timer.intervalRestart());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 花费分钟数 " + timer.intervalMinute());
    }
}
