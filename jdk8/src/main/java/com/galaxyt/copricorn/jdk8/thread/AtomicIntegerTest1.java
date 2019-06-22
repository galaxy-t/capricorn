package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic 保证基础类型原子性
 * 此处示例使用AtomicInteger进行演示
 * @author zhouqi
 * @date 2019-06-13 11:45
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 11:45     zhouqi          v1.0.0           Created
 *
 */
public class AtomicIntegerTest1 {

    public static int count = 0;

    static AtomicInteger ac = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                count++;
                ac.incrementAndGet();
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println(count);
        System.out.println(ac.get());


    }


}
