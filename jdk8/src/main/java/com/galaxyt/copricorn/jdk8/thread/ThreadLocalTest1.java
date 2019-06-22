package com.galaxyt.copricorn.jdk8.thread;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程本地变量 OR 线程本地存储
 * 为变量在每个线程中都创建了一个副本，每个线程可以访问自己内部的副本变量
 *
 * 每一个线程都有一个自己的副本，不需要去考虑线程不安全的问题
 *
 * @author zhouqi
 * @date 2019-06-13 14:04
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 14:04     zhouqi          v1.0.0           Created
 *
 */
public class ThreadLocalTest1 {


    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    threadLocal.set(UUID.randomUUID().toString());
                    new OrderService().get();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }


        try {
            //让latch一直处于等待状态
            //latch为0时才会继续往下走
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("success");

        executorService.shutdown();
    }



}


class OrderService {

    public void get(String reqId) {
        System.out.println("---" + reqId);
    }


    public void get() {
        System.out.println(ThreadLocalTest1.threadLocal.get());
    }
}
