package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.*;

/**
 * 线程池的增强使用
 * 拒绝策略
 * 在线程池溢出的状态下，溢出部分的线程会被放入队列中去，但是当队列的大小达到一定的量的时候可能会导致内存溢出或系统运行变卡
 * 可以通过信号量来控制接收线程的速度
 * 或者在某些情况下直接抛弃
 * @author zhouqi
 * @date 2019-06-13 15:13
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 15:13     zhouqi          v1.0.0           Created
 *
 */
public class ThreadPoolProTest2 {


    public static void main(String[] args) {

        ExecutorService es  = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new SynchronousQueue<>(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                System.out.println("满了");



            }
        });


        for (int i = 0; i < 1000; i++) {

            es.execute(() -> {

                System.out.println("===");

                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }


    }


}
