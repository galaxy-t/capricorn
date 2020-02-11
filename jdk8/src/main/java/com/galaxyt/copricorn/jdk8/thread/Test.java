package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {


        System.out.println(Thread.currentThread().getId());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {

            System.out.println(Thread.currentThread().getId());

        });

        executorService.submit(() -> {

            System.out.println(Thread.currentThread().getId());

        });

        executorService.submit(() -> {

            System.out.println(Thread.currentThread().getId());

        });






    }



}
