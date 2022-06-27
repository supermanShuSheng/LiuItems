package com.shusheng.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author 刘闯
 * @date 2021/8/23.
 */
public class CountDownLatchUtil {
    public static void main(String[] args) {
        // 计数器
        CountDownLatch c = new CountDownLatch(5);

        // 计数器-1
        c.countDown();

        // 阻塞
        try {
            c.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
