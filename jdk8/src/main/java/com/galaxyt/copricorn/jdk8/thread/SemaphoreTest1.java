package com.galaxyt.copricorn.jdk8.thread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 用于处理并发时候的控制，限流等
 * @author zhouqi
 * @date 2019-06-13 13:55
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 13:55     zhouqi          v1.0.0           Created
 *
 */
public class SemaphoreTest1 {

    public static void main(String[] args) {

        Instant start = Instant.now();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(100);

        //初始化时设置信号量的数量
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    //尝试拿到一个执行请求
                    //若拿不到则阻塞等待
                    semaphore.acquire();

                    Thread.sleep(100);
                    System.out.println("---");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //在执行完成之后释放这个信号量
                    semaphore.release();
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

        Instant end = Instant.now();

        System.out.println("success" + Duration.between(start,end).toMillis());

        executorService.shutdown();

    }



}
