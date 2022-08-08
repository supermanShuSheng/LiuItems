package com.shusheng.demo;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;

/**
 * @author 刘闯
 * @date 2021/6/8.
 */
public class Demo {
    public static void main(String[] args) {

        setLatLng("(二十里丛慧）PMS_临时支#4");
    }

    public static void setLatLng(String latLng) {
        if (StrUtil.isBlank(latLng)) {
            return;
        }

        String[] split = latLng.split(",");
        if (split.length < 2) {
            split = latLng.split("，");
            if (split.length < 2) {
                return;
            }
        }

        System.out.println(Arrays.toString(split));
    }
    /**
     * @param second 秒
     * @description: 秒转换为时分秒 HH:mm:ss 格式 仅当小时数大于0时 展示HH
     * @return: {@link String}
     * @author: pzzhao
     * @date: 2022-05-08 13:55:17
     */
    public static String second2Time(Long second) {
        if (second == null || second < 0) {
            return "00:00";
        }

        long h = second / 3600;
        long m = (second % 3600) / 60;
        long s = second % 60;
        String str = "";
        if (h > 0) {
            str = (h < 10 ? ("0" + h) : h) + ":";
        }
        str += (m < 10 ? ("0" + m) : m) + ":";
        str += (s < 10 ? ("0" + s) : s);
        return str;

    }

}
