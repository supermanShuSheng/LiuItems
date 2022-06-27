package com.shusheng.utils;

import cn.hutool.core.util.RuntimeUtil;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class cmdUtil {
    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println("str = " + str);
    }
}
