package com.shusheng.bean;

import com.shusheng.utils.BeanConvertUtils;

/**
 * @author 刘闯
 * @date 2021/7/1.
 */
public class TestBean {
    public static void main(String[] args) {
        MM mm = new MM();
        mm.setUserId("123");
        mm.setUserName("456");
        mm.setUserAge("789");

        NN nn = BeanConvertUtils.convertTo(mm, NN::new);
        System.out.println("nn = " + nn);
    }


}
