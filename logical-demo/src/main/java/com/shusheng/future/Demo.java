package com.shusheng.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 刘闯
 * @date 2021/5/26.
 */
public class Demo {
    public static void main(String[] args) {
        FutureDemo futureDemo = new FutureDemo();
        Future<Integer> calculate = futureDemo.getCalculate(20);

        // 判断该线程是否结束
        while (!calculate.isDone()){
            try {
                System.out.println(" 等待！！！！ ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果结束 获取值
        try {
            Integer integer = calculate.get();
            System.out.println("integer = " + integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
