package com.shusheng.utils;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
public class LoginVailUtils {

    /**
     * 登录认证
     */
    public static void initSecurity(){
        SecurityUtil bean = SpringBeanUtil.getBean(com.shusheng.utils.SecurityUtil.class);
        bean.logInAs("haha1");
    }
}
