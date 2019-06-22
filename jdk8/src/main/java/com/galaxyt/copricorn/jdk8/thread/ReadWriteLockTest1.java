package com.galaxyt.copricorn.jdk8.thread;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 读写锁
 *  多个线程可同时读取数据,读的时候是不能写入的
 *  同时只能又一个线程写数据，并且一旦开始写数据，读数据操作不被允许，直到写数据释放锁
 *
 *  读写两种操作互斥
 *  读可以同时又多个线程
 *  写仅能又一个线程
 *
 * @author zhouqi
 * @date 2019-06-13 10:40
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 10:40     zhouqi          v1.0.0           Created
 *
 */
public class ReadWriteLockTest1 {

    private static Map<String, String> cacheMap = new HashMap<>();

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Instant begin = Instant.now();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(getData2("a"));
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        Instant end = Instant.now();

        Duration duration = Duration.between(begin, end);

        System.out.println(duration.toMillis());

    }

    /*
    2.
    添加synchronized锁
    可以有效控制map线程不安全的问题，但是耗时需要10128毫秒
     */
    public static String getData(String key) {

        /*
        1.
        设置每个线程进入该方法需要等待一秒
        用于模拟方法耗时
        耗费总时间1089毫秒
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        3.
        使用同步代码块也可以解决线程不安全问题
        耗时1090毫秒
        此时仅需要保证读写操作线程安全即可
         */
        synchronized (ReadWriteLockTest1.class) {
            String value = cacheMap.get(key);

            if (value == null) {
                System.out.println("----");
                cacheMap.put(key, "aaaaaa");
            }
        }


        return cacheMap.get(key);


    }


    public static String getData2(String key) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.readLock().lock();

        String value = cacheMap.get(key);

        if (value == null) {
            lock.readLock().unlock();
            lock.writeLock().lock();

            /*
            在拿到写锁之后再进行一次判断
            Double Check
            以防止在拿锁的过程中其它线程已经完成了写操作
            此处演示没有使用try--catch---finally
            但是实际开发过程中使用锁的情况必须使用try--catch---finally
             */
            if (cacheMap.get(key) == null) {
                System.out.println("----");
                cacheMap.put(key, "aaaaaa");
            }
            lock.writeLock().unlock();

        }

        try {
            lock.readLock().lock();
            return cacheMap.get(key);
        }finally {      //finally会先被进入，然后再进行返回
            System.out.println("最终释放读锁");
            lock.readLock().unlock();
        }

    }

}
