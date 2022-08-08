package com.shusheng.datax;


import com.alibaba.datax.core.Engine;

/**
 * @author 刘闯
 * @date 2022/7/25
 */
public class TestDemo {
    public static void main(String[] args) {
        System.setProperty("datax.home", "G:\\datax");
        String[] dataxArgs = {"-job", "G:\\TheProgram\\Java\\LiuItems\\datax-demo-4021\\src\\main\\resources\\job_json\\sql_server_to_mysql_curv.json", "-mode", "standalone", "-jobid", "-1"};
        try {
            Engine.entry(dataxArgs);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
