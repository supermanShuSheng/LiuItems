package com.shusheng.utils;

/**
 * @author 刘闯
 * @date 2021/8/19.
 */
public class CommUtils {

    /**
     * 如果字符串为空则替换为null
     * @param obj 字符串
     * @return
     */
    public static String checkMap(Object obj) {
        String str = obj + "";
        if ("null".equals(str) || "".equals(str)) {
            return null;
        } else {
            return str;
        }
    }
}
