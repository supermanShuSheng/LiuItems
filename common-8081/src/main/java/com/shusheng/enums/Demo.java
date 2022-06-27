package com.shusheng.enums;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/7/14.
 */
public class Demo {
    public static void main(String[] args) {
        String val = GroupEntity.A.getVal();
        int sub = Integer.parseInt(val.substring(val.lastIndexOf(",") + 1));
        List<String> list = new ArrayList<>();
        list.add("remove");
        list.add("post");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        for (int i = 1; i <= sub; i ++){
            val = val.replaceAll(i+"", list.get(i-1));
        }
        System.out.println("primary = " + GroupEntity.A + " Value = " + val);
    }
}
