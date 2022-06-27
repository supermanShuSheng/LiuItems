package com.shusheng.utils;

import com.shusheng.commons.R;

import java.util.ArrayList;

/**
 * 返回结果工具类
 * @author 刘闯
 * @date 2021/3/19.
 */
public class ResultUtils {
    /**
     * 请求数据成功
     * @param data  数据
     * @param total  大小
     * @param msg  消息
     * @return  R对象
     */
    public static <T> R<T> success(T data, Integer total, String msg){
        return new R<T>(data, total, 700, msg);
    }

    public static <T> R<T> success(T data, Integer total){
        return new R<T>(data, total, 700, "请求成功！");
    }

    public static <T> R<T> success(T data, String msg){
        return new R<T>(data, 1, 700, msg);
    }

    public static <T> R<T> success(String msg){
        return new R<T>(null, 0, 700, msg);
    }

    public static <T> R<T> success(Integer code, String msg){
        return new R<T>(null, 0, code, msg);
    }

    public static <T> R<T> success(){
        return new R<T>(null, 0, 700,null);
    }

    public static <T> R<T> error(T data, Integer total, String msg){
        return new R<T>(data, total, 701, msg);
    }

    public static <T> R<T> error(T data, Integer total){
        return new R<T>(data, total, 701, "请求失败");
    }

    public static <T> R<T> error(T data, String msg){
        return new R<T>(data, 1, 701, msg);
    }

    public static <T> R<T> error(Integer code, String msg){
        return new R<T>(null, 0, code, msg);
    }

    public static <T> R<T> error(String msg){
        return new R<T>(null, 0, 701, msg);
    }

    public static <T> R<T> error(){
        return error(null,0);
    }
}
