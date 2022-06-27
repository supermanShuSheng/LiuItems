package com.shusheng.reflect;

import cn.hutool.core.util.ReflectUtil;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 刘闯
 * @date 2021/6/30.
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 类加载
        Class<Cat> baseCat = Cat.class;
        // 获取具体的方法
        Method sayCat = baseCat.getMethod("sayCat", String.class);
        // 通过类加载执行方法
        sayCat.invoke(new Cat(), "123");

        // 测试静态
        Method sayDot = baseCat.getMethod("sayDot", String.class);
        sayDot.invoke(null , "12345");


        SonReflect son = new SonReflect();
        son.setPageSize(10);
//        son.setPageNo(1);

        getReflect(son);
    }

    /**
     * 通过反射获取pageSize  pageNo
     * @param t
     */
    public static <T> void getReflect(T t){
//        try {
//            Method getPageSize = ReflectUtil.getMethod(t.getClass(), "getPageSize", Integer.class);
//
//            System.out.println(getPageSize);

        Object pageSize = ReflectUtil.getFieldValue(t, "pageSize");
        Object pageNo = ReflectUtil.getFieldValue(t, "pageNo");
        System.out.println(pageSize+"  ==  "+pageNo);


//            Method pageSize = cla.getMethod("getPageSize", Integer.class);
//            Object invoke = pageSize.invoke(cla, null);
//            System.out.println("invoke = " + invoke);

//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }


    }
}
