package com.shusheng.controller;

import com.shusheng.mapper.KakMapper;
import com.shusheng.utils.ApplicationBeanUtil;

/**
 * @author 刘闯
 * @date 2021/10/18.
 */
public class BeanUtilsDemo {

    public static String getBeanDemo(){
        KakMapper bean = ApplicationBeanUtil.getBean(KakMapper.class);
        if (bean == null){
            return "false";
        }

        return bean.getName();
    }
}
