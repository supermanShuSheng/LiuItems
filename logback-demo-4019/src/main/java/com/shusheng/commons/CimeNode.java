package com.shusheng.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 刘闯
 * @date 2022/8/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CimeNode {

    /**
     * 注释值
     * @return
     */
    String value();
}
