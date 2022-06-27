package com.shusheng.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author 刘闯
 * @date 2021/5/8.
 */
public class ValuesDemo {

    /**
     * 枚举测试
     * @param args 参数
     */
    public static void main(String[] args) {

        Optional<VoltEnum> volt_level = Arrays.stream(VoltEnum.values()).filter(x -> x.getNo().equals("33")).findFirst();
        System.out.println("volt_level.isPresent() = " + volt_level.isPresent());
        if (volt_level.isPresent()){
            System.out.println("volt_level = " + volt_level);
        }
    }
}
