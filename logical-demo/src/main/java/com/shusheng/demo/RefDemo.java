package com.shusheng.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 刘闯
 * @date 2021/7/5.
 */
public class RefDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "C++","php","java");
        Map<Boolean, List<String>> result = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println("result = " + result);
    }
}
