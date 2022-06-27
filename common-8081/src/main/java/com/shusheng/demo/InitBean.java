package com.shusheng.demo;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/8/10.
 */
@Data
@Component
public class InitBean implements InitializingBean {

    private String beanName;

    private String beanAge;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("beanName = " + beanName);
    }
}
