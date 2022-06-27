package com.shusheng.domain;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 刘闯
 * @date 2021/9/28.
 */
public class JSONStrDemo {
    public static void main(String[] args) {
        String str = "{\"xssb\":[[{\"objId\":\"51f5eea973624ccda046507cc5aec71b\",\"xsId\":\"980d4c2d04ae417997905c39d8e004be\",\"equipId\":\"1803cb77d1e24a00b5eeaa636c6a9aec\",\"equipType\":\"LSPMS_ARCH_D_IT\",\"equipName\":\"电压互感器123\"}]]}";

        JsonEntity jsonStrDemo = JSONObject.parseObject(str, JsonEntity.class);
        System.out.println("jsonStrDemo = " + jsonStrDemo);
    }
}
