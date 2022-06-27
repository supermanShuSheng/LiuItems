package com.shusheng.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 刘闯
 * @date 2021/9/23.
 */
public class JSONArrayDemo {
    public static void main(String[] args) {
        JSONArray js = new JSONArray();
        JSONObject jb = new JSONObject();
        jb.put("123","456");
        js.add(jb);

        String s = js.toString();
        System.out.println("s = " + s);
        String str = "";

        JSONArray.parseArray(str);
    }
}
