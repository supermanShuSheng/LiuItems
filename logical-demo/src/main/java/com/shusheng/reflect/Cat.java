package com.shusheng.reflect;

import lombok.Data;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
@Data
public class Cat {
    private String catName;

    private String catLove;

    public void sayCat(String say){
        System.out.println("say = " + say);
    }

    public static void sayDot(String say){
        System.out.println("say = " + say);
    }
}
