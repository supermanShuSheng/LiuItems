package com.shusheng.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/6/16.
 */
@Component
@ConfigurationProperties(prefix = "person")
public class PassPerson {
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private String age;

    @Override
    public String toString() {
        return "PassPerson{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public PassPerson() {
    }

    public PassPerson(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
