package com.shusheng.utils;

import cn.hutool.core.date.DateUtil;
import com.shusheng.config.BaseException;

import java.util.Arrays;
import java.util.Date;

/**
 * 时间范围检验工具
 * @author 刘闯
 * @date 2021/10/25.
 */
public class DateValidUtil {

    /**
     * 按照传参顺序进行校验 (相等不报错)
     * @param dates
     * @example 2021-05-03  2021-05-04 2021-05-06 返回 true
     * @example 2021-05-03  2021-05-04 2021-05-03 返回 false
     */
    public static void validRangeDates(Date... dates) {
        validRangeDates(false, dates);
    }

    /**
     * 按照传参顺序进行校验
     * @param equality true 不允许相等  false 允许相等
     * @param dates 时间数据
     * @example 2021-05-03  2021-05-04 2021-05-06 返回 true
     * @example 2021-05-03  2021-05-04 2021-05-03 返回 false
     */
    public static void validRangeDates(boolean equality, Date ... dates){
        // 如果个数小于2
        if (dates.length <= 1){
            throw new BaseException("参数个数不得小于2");
        }
        Arrays.stream(dates).forEach(x->{
            if (x == null){
                throw new BaseException("日期不得为空！");
            }
        });
        // 进行校验
        for (int i = 0; i < dates.length-1; i ++) {
            if (equality){
                if (DateUtil.compare(dates[i], dates[i+1]) >= 0){
                    throw new BaseException("日期范围错误！");
                }
            } else {
                if (DateUtil.compare(dates[i], dates[i+1]) > 0){
                    throw new BaseException("日期范围错误！");
                }
            }

        }
    }

    /**
     * 按照传参顺序进行校验 (相等不报错)
     * @param format 格式化参数
     * @param strs 日期
     * @example 2021-05-03  2021-05-04 2021-05-06 返回 true
     * @example 2021-05-03  2021-05-04 2021-05-03 返回 false
     */
    public static void validRangeDates(String format, String... strs) {
        Date[] dates = null;
        try {
            dates = Arrays.stream(strs).map(x -> DateUtil.parse(x, format))
                    .toArray(Date[]::new);
        }catch (Exception e){
            throw new BaseException("日期格式化错误！");
        }
        validRangeDates(false, dates);
    }
}
