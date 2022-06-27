package com.shusheng.commons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RUNTIME 运行时
 * FIELD 字段
 * @author 刘闯
 * @date 2021/3/22.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CreateDate {
    String value() default "";
}
