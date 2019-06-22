package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的增强使用
 * 重写某些方法，对线程或线程池的状态作环绕
 *
 * @author zhouqi
 * @version v1.0.0
 * @date 2019-06-13 15:01
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2019-06-13 15:01     zhouqi          v1.0.0           Created
 */
public class ThreadPoolProTest1 {

    public static void main(String[] args) {


        //自己创建一个线程池
        //初始线程数5
        //最大线程数10
        //线程限时1秒则销毁
        //线程队列
        ExecutorService es  = new ThreadPoolExecutor(5,10,1, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>()){


            @Override
            protected void beforeExecute(Thread t, Runnable r) {

                System.out.println("某个线程开始执行之前");

                super.beforeExecute(t, r);
            }


            @Override
            protected void afterExecute(Runnable r, Throwable t) {

                System.out.println("某个线程执行完成之后");

                super.afterExecute(r, t);
            }


            @Override
            protected void terminated() {

                System.out.println("线程池停止");

                super.terminated();
            }
        };


        es.execute(() -> System.out.println("----"));
        es.execute(() -> System.out.println("===="));

        es.shutdown();


    }

}
