package com.shusheng.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 刘闯
 * @date 2021/5/26.
 */
public class FutureDemo {
    /**、
     *   创建一个单线程
     *
     */
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 获取一个数的平房
     * @param integer 数字
     * @return  平方
     */
    public Future<Integer> getCalculate(Integer integer){
        // 获取线程结果
        return executorService.submit(()->{
            Thread.sleep(5000);
            return integer*integer;
        });
    }
}
