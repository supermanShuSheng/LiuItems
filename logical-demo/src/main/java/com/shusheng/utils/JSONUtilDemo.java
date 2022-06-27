package com.shusheng.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.List;

/**
 * JSON工具
 * @author 刘闯
 * @date 2021/5/27.
 */
public class JSONUtilDemo {
    public static void main(String[] args) {
        //language=JSON
        String str = "{\n" +
                "  \"id\"" +
                " : \"123\",\n" +
                "  \"name\" : \"刘闯\",\n" +
                "  \"aaa\" : [{\n" +
                "    \"qqq\": \"123\",\n" +
                "    \"www\": \"456\",\n" +
                "    \"eee\": \"789\"\n" +
                "  }]\n" +
                "}";
        JSONObject jsonObject = JSONUtil.parseObj(str);
        System.out.println("jsonObject = " + jsonObject);
        // json 转实体
        User user = JSONUtil.toBean(jsonObject, User.class);
        System.out.println("user = " + user);
        // 实体转json
        JSON parse = JSONUtil.parse(user);
        System.out.println("parse = " + parse);

    }


    public class User{
        String id;
        String name;
        List<AA> aaa;

        public User() {
        }

        public User(String id, String name, List<AA> aaa) {
            this.id = id;
            this.name = name;
            this.aaa = aaa;
        }

        public List<AA> getAaa() {
            return aaa;
        }

        public void setAaa(List<AA> aaa) {
            this.aaa = aaa;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", aaa=" + aaa +
                    '}';
        }
    }



    public class AA{
        String qqq;
        String www;
        String eee;

        public AA(String qqq, String www, String eee) {
            this.qqq = qqq;
            this.www = www;
            this.eee = eee;
        }

        public AA() {
        }

        public String getQqq() {
            return qqq;
        }

        public void setQqq(String qqq) {
            this.qqq = qqq;
        }

        public String getWww() {
            return www;
        }

        public void setWww(String www) {
            this.www = www;
        }

        public String getEee() {
            return eee;
        }

        public void setEee(String eee) {
            this.eee = eee;
        }

        @Override
        public String toString() {
            return "AA{" +
                    "qqq='" + qqq + '\'' +
                    ", www='" + www + '\'' +
                    ", eee='" + eee + '\'' +
                    '}';
        }
    }
}
