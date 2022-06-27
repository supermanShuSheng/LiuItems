package com.shusheng.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*
* @author 刘闯
* @date 2021/7/19.
* 递归测试
*/
public class recursive {
    public static void main(String[] args) {
//        diGuiOne();

//        diGuiTwo();

        diGuiThree();
    }
    // 斐波那契数列
    private static void diGuiThree() {
        System.out.println("斐波那契数列 = " + fib(0));
    }

    private static int fib(int i) {
        if (i < 2){
            return i;
        }
        return fib(i-1)+fib(i-2);
    }

    //  帕斯卡三角形
    private static void diGuiTwo() {
        System.out.println("帕斯卡三角形 = " + f(5, 3));
    }

    private static int f(int f1, int f2) {
        if (f2 == 1 ||  f2 == f1){
            return 1;
        }
        return  f(f1-1, f2-1) + f(f1-1, f2);
    }


    private static void diGuiOne(){
        List<JSONObject> js = getJson();
//        System.out.println("js = " + js);
        List<String> str = findId(js, "rootDLFZX110700000018");
        if (str != null){
            str.forEach(System.out::println);
        }
    }

    /**
     * 查找ID
     * @param js
     * @param id
     */
    private static List<String> findId(List<JSONObject> js, String id) {

        for (JSONObject j : js) {
            // 结束条件
            if (j.getString("id").equals(id)){
                List<String> list = new ArrayList<>();
                list.add(j.getString("name"));
                return list;
            }
            // 递归
            if (j.containsKey("children")){
                JSONArray children = j.getJSONArray("children");
                List<String> id1 = findId(children.toJavaList(JSONObject.class), id);
                if (id1 != null){
                    id1.add(j.getString("name"));
                    return id1;
                }
            }
        }
        return null;
    }


    /**
     * recursive
     * @return
     */
    private static List<JSONObject> getJson() {
        return JSONArray.parseArray("[\n" +
                "    {\n" +
                "      \"id\": \"rootTran\",\n" +
                "      \"name\": \"主变\",\n" +
                "      \"menuVo\": {\n" +
                "        \"equipId\": \"rootTran\",\n" +
                "        \"equipName\": \"主变\",\n" +
                "        \"equipType\": null\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": \"21bfb5c4-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "          \"name\": \"新店儿1TM变压器\",\n" +
                "          \"assetsType\": \"Tran\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"21bfb5c4-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "            \"equipName\": \"新店儿1TM变压器\",\n" +
                "            \"equipType\": \"Tran\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"rootBusLine\",\n" +
                "      \"name\": \"母线\",\n" +
                "      \"menuVo\": {\n" +
                "        \"equipId\": \"rootBusLine\",\n" +
                "        \"equipName\": \"母线\",\n" +
                "        \"equipType\": null\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": \"21232785-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "          \"name\": \"新店儿35KV母线\",\n" +
                "          \"assetsType\": \"BusLine\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"21232785-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "            \"equipName\": \"新店儿35KV母线\",\n" +
                "            \"equipType\": \"BusLine\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"21232786-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "          \"name\": \"新店儿10KV母线\",\n" +
                "          \"assetsType\": \"BusLine\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"21232786-2a0f-11eb-b60d-691b9f5bfce3\",\n" +
                "            \"equipName\": \"新店儿10KV母线\",\n" +
                "            \"equipType\": \"BusLine\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"rootXL\",\n" +
                "      \"name\": \"线路\",\n" +
                "      \"menuVo\": {\n" +
                "        \"equipId\": \"rootXL\",\n" +
                "        \"equipName\": \"线路\",\n" +
                "        \"equipType\": null\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"id\": \"11990000041\",\n" +
                "          \"name\": \"522#新罗线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11990000041\",\n" +
                "            \"equipName\": \"522#新罗线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11990000041\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11990000041\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11990000041\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11990000041\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"11070000008\",\n" +
                "          \"name\": \"925#新胜线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11070000008\",\n" +
                "            \"equipName\": \"925#新胜线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11070000008\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11070000008\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11070000008\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11070000008\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"11070000009\",\n" +
                "          \"name\": \"926#新和线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11070000009\",\n" +
                "            \"equipName\": \"926#新和线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11070000009\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11070000009\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11070000009\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11070000009\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"11070000010\",\n" +
                "          \"name\": \"927#新大线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11070000010\",\n" +
                "            \"equipName\": \"927#新大线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11070000010\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11070000010\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11070000010\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11070000010\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"11070000011\",\n" +
                "          \"name\": \"928#新双线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11070000011\",\n" +
                "            \"equipName\": \"928#新双线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11070000011\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11070000011\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11070000011\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11070000011\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"11070000012\",\n" +
                "          \"name\": \"929#新南线\",\n" +
                "          \"assetsType\": \"Xl\",\n" +
                "          \"menuVo\": {\n" +
                "            \"equipId\": \"11070000012\",\n" +
                "            \"equipName\": \"929#新南线\",\n" +
                "            \"equipType\": \"Xl\"\n" +
                "          },\n" +
                "          \"children\": [\n" +
                "            {\n" +
                "              \"id\": \"rootDL11070000012\",\n" +
                "              \"name\": \"电缆\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDL11070000012\",\n" +
                "                \"equipName\": \"电缆\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"rootDLFZX11070000012\",\n" +
                "              \"name\": \"电缆分子箱\",\n" +
                "              \"menuVo\": {\n" +
                "                \"equipId\": \"rootDLFZX11070000012\",\n" +
                "                \"equipName\": \"电缆分子箱\",\n" +
                "                \"equipType\": null\n" +
                "              }\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"rootPb\",\n" +
                "      \"name\": \"配变\",\n" +
                "      \"menuVo\": {\n" +
                "        \"equipId\": \"rootPb\",\n" +
                "        \"equipName\": \"配变\",\n" +
                "        \"equipType\": null\n" +
                "      }\n" +
                "    }\n" +
                "  ]", JSONObject.class);
    }
}
