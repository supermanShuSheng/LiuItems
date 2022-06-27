package com.shusheng.utils;

import cn.hutool.core.util.ReflectUtil;
import com.shusheng.reflect.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class RefUtil {
    public static void main(String[] args) {
        // 获取某个类的所有方法
        Method[] methods = ReflectUtil.getMethods(Cat.class);
        // 获取某个类的指定方法
        Method method = ReflectUtil.getMethod(Cat.class, "sayDot", String.class);
        // 构造对象
        Cat cat = ReflectUtil.newInstance(Cat.class);
        // 执行方法
        ReflectUtil.invoke(cat, method,"hello");

        Cat cat1 = new Cat();
        cat1.setCatName("123");

        Field catName = ReflectUtil.getField(Cat.class, "catName");

        System.out.println("通过反射获取属性值 = " + ReflectUtil.getFieldValue(cat1, catName));

        // 通过反射设置属性值
        ReflectUtil.setFieldValue(cat1, "catLove", "打篮球");

        System.out.println("cat1 ==== "+cat1);
        // 执行静态方法
        ReflectUtil.invokeStatic(method,"123");
    }
}
