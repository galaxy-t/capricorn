package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程计数器
 * @author zhouqi
 * @date 2019-06-13 13:53
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 13:53     zhouqi          v1.0.0           Created
 *
 */
public class CountDownLatchTest1 {


    static int count = 2;


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("---");
                    latch.countDown();
                } catch (InterruptedException e) {
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
