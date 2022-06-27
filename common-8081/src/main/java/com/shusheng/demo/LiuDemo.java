package com.shusheng.demo;

import org.springframework.stereotype.Component;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
@Component
public class LiuDemo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LiuDemo(String name) {
        this.name = name;
    }

    public LiuDemo() {
    }

    @Override
    public String toString() {
        return "LiuDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
