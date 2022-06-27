package com.shusheng.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author 刘闯
 * @date 2021/7/12.
 */
public class LomberDeom {
    public static void main(String[] args) {

        Consumer c = System.out::println;
        c.accept("123");
        Function f = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };

        Function f1 = (o) -> "123";
        System.out.println(f1.apply("1111"));
        Predicate p = (o) ->{
            return  false;
        };

    }
}
