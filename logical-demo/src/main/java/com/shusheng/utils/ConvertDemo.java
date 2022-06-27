package com.shusheng.utils;

import cn.hutool.core.convert.Convert;

/**
 * 类型转换工具
 * @author 刘闯
 * @date 2021/5/27.
 */
public class ConvertDemo {
    public static void main(String[] args) {
        // 将金额装换成人民币大写
        double a = 67556.32;
        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
        System.out.println("digitUppercase = " + digitUppercase);
    }
}
