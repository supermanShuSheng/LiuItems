package com.shusheng.demo;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author 刘闯
 * @date 2021/7/6.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        // 获取代理对象
        Calculator c1 = (Calculator) getProxy(calculator);
        c1.add(1, 2);
        c1.subtract(2, 1);
    }


    private static Object getProxy(final Object target) {
        /*代理对象的方法最终都会被JVM导向它的invoke方法*/
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),/*类加载器*/
                target.getClass().getInterfaces(),/*让代理对象和目标对象实现相同接口*/
                (proxy, method, args) -> {
                    System.out.println(method.getName() + "方法开始执行...");
                    Object result = method.invoke(target, args);
                    System.out.println(result);
                    System.out.println(method.getName() + "方法执行结束...");
                    return result;
                }
        );
    }
}
