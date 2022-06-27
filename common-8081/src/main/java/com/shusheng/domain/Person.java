package com.shusheng.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘闯
 * @date 2021/2/4.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    int id;
    String name;
    int age;
}
