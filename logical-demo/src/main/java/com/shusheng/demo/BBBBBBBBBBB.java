package com.shusheng.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shusheng.entiy.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2021/6/28.
 */
public class BBBBBBBBBBB {
    public static void main(String[] args) {
        List<Account> accountsList = new ArrayList<>();
        Account account = new Account();
        account.setMobile("123");
        account.setAccountName("456");
        accountsList.add(account);
        Account account1 = new Account();
        account1.setMobile("流");
        account1.setAccountName("");
        accountsList.add(account1);
        String s = JSONArray.toJSONString(accountsList, SerializerFeature.WRITE_MAP_NULL_FEATURES);
        System.out.println("s = " + s);
        Object parse = JSONArray.parse(s);
        System.out.println("parse = " + parse);

        List<JSONObject> jsonObjects = JSON.parseArray(s, JSONObject.class);
        System.out.println("jsonObjects = " + jsonObjects);

        List<Account> accounts = JSON.parseArray(s, Account.class);
        System.out.println("accounts = " + accounts);
        JSONArray objects = JSON.parseArray(s);
        System.out.println("objects = " + objects);
    }
}
