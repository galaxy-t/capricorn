package com.galaxyt.copricorn.jdk8.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程安全的HashMap
 *
 *
 * @author zhouqi
 * @date 2019-06-13 14:12
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 14:12     zhouqi          v1.0.0           Created
 *
 */
public class ConcurrentHashMapTest1 {


    public static void main(String[] args) {

        //HashMap，线程不安全，在多线程的情况下可能会出现数据丢失的情况
        //Map<String, String> map = new HashMap<>();

        //为Map的全部方法都加上了同步锁，并发量不大的情况下可以使用此操作，但是并发量过大的情况下会降低可伸缩性
        //Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        //保证原子性，适用于高并发，通过分段锁的概念实现
        //普通的锁，一个对象一把锁
        //分段锁，将一个对象的分解成多段，每一段又一把锁
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

                ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {

            String key = i + "";

            executorService.execute(() -> {

                try {
                    Thread.sleep(110);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                map.put(key, key);

            });

        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }


        System.out.println(map.get("2"));

        System.out.println(map.size());


    }


}
