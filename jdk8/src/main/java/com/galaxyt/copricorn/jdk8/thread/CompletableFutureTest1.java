package com.galaxyt.copricorn.jdk8.thread;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

/**
 * JDK8新增有返回值的线程
 * @author zhouqi
 * @date 2019-06-13 16:21
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 16:21     zhouqi          v1.0.0           Created
 *
 */
public class CompletableFutureTest1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            return "result";
        }, executorService);    //也可以不设置线程池，默认会有一个线程池

        //future.get()  阻塞的方法
        //future.join() 非阻塞的方法


        System.out.println(future.join());

        /*
        非阻塞
        在线程执行完成之后得到结果用于处理
         */
        future.thenAccept(r -> {
            System.out.println(r);
        });

        /*
        在线程执行完成之后再启动一个线程用于执行
         */
        future.thenRun(() -> {

        });


        /*
        基于future线程之后再执行一个线程，得到第一个线程的返回值，并且再返回一个线程
        第二个任务依赖于第一个任务的结果，并且第二个任务也会有返回值
         */
        CompletableFuture<String> future2 = future.thenApply(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return s + "sdfkj";
            }
        });

        System.out.println(future2.get());

        executorService.shutdown();


        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {

            return "future3";
        });

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {

            return "future4";
        });

        /*
        等future3和future4都运行完了，将两个的结果收集起来之后再处理运行
         */
        CompletableFuture<String> future5 = future3.thenCombine(future4,(t,u) -> {

            return t + u;
        } );


        System.out.println(future5.join());


    }



}
