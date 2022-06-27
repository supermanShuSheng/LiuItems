package com.shusheng.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author 刘闯
 * @date 2021/5/28.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class B extends A{
    private String bbb;
}
