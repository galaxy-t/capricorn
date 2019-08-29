package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池
 *
 * @author zhouqi
 * @date 2019-06-13 14:42
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 14:42     zhouqi          v1.0.0           Created
 *
 */
public class ThreadPoolTest1 {

    public static void main1(String[] args) {

        //创建一个固定大小的线程池，当线程数量超过指定数量，超出的线程会放到一个队列中去等待处理
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //创建一个带缓存的线程池，默认初始化线程池内线程数量为0，又需要的时候会创建一个线程，每个线程执行完成之后会等待60秒，若60秒内没有被重新使用则销毁这个线程
        //一个长时间不被使用的缓存线程池消耗几乎为0
        ExecutorService executorService1 = Executors.newCachedThreadPool();

        //里面只有一个线程工作的线程池
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        //任务调度的线程池
        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        //设置一个任务，在发布之后5秒开始，每一秒执行一次
        executorService3.scheduleAtFixedRate(() -> System.out.println("..."),5,1, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {




        Executors.newSingleThreadScheduledExecutor(r -> {

            return new Thread(r);

        }).scheduleAtFixedRate(() -> {

            System.out.println(Thread.currentThread().getName());

        },5,5,TimeUnit.SECONDS);


    }


}
