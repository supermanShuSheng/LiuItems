package com.shusheng.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * fork 测试
 * @author 刘闯
 * @date 2021/5/26.
 */
public class ForkDemo {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println("使用Fork开始时间 =====" + startTime);
        ComputeNums computeNums = new ComputeNums(1, 100000000);
        computeNums.compute();
        // 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //  执行线程
        ForkJoinTask<Integer> submit = forkJoinPool.submit(computeNums);
        // 获取线程结果
        try {
            Integer integer = submit.get();
            System.out.println("integer = " + integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("使用Fork结束时间 =====" + endTime);
        System.out.println("Fork总共用时为 ===== "+ (endTime-startTime));

        startTime = System.currentTimeMillis();
        System.out.println("使用普通开始时间 =====" + startTime);

        int sum = 0;
        for (int i = 1; i <= 1000000000; i ++){
            sum += i;
        }
        System.out.println("sum = " + sum);
        endTime = System.currentTimeMillis();
        System.out.println("使用普通结束时间 =====" + endTime);
        System.out.println("普通总共用时为 ===== "+ (endTime-startTime));

    }
}
