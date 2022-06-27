package com.shusheng.demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘闯
 * @date 2021/6/16.
 */
@Data
public class LombokDemo {

    /**
     * 测试年龄
     */
    private String age;
    /**
     * 测试名称
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String name;
}
