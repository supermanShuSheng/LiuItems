package com.shusheng.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/7/21.
 */
public class ListDemo {
    public static void main(String[] args) {
        Object obj = getObj();
        List<String> list = new ArrayList<>();
        list.addAll((List<String>) obj);

//        list = (List<String>) obj;
        System.out.println("list = " + list);
    }

    public static Object getObj() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("ab");
        return list;
    }
}
