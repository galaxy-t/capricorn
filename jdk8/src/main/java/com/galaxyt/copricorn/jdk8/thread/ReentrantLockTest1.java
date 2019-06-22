package com.galaxyt.copricorn.jdk8.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * 1.可重入
 * 2.可公平
 *      默认是非公平锁
 *      想要实现公平锁 ReentrantLock lock = new ReentrantLock(true);
 *      需要在构造时构造函数设置为true
 * 3.可中断
 * 4.可限时
 *
 * 可以理解为是synchronized的加强版
 *
 * @author zhouqi
 * @date 2019-06-13 09:57
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 09:57     zhouqi          v1.0.0           Created
 *
 */
public class ReentrantLockTest1 {


    public static void main(String[] args) {

        //可重入
        /*ReenLock reenLock = new ReenLock();

        new Thread(reenLock).start();
        new Thread(reenLock).start();*/


        //可中断
        /*StopLock stopLock = new StopLock();

        Thread t1 = new Thread(stopLock);
        t1.setName("t1");

        Thread t2 = new Thread(stopLock);
        t2.setName("t2");

        t1.start();


        try {
            Thread.sleep(100);
            t2.start();
            Thread.sleep(1000);
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        TimeLock timeLock = new TimeLock();
        new Thread(timeLock).start();
        new Thread(timeLock).start();


    }


}

/**
 * 可限时
 */
class TimeLock implements Runnable {

    public ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {

            //lock.tryLock()    判断在同一时刻内能够拿到线程，能拿到线程直接加锁并返回true，否则直接返回false

            if (lock.tryLock(3, TimeUnit.SECONDS)) {    //等待三秒看是否能够拿到锁
                System.out.println("get lock");
                Thread.sleep(5000);
            } else {
                System.out.println("not get lock");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //判断如果当前线程拿到锁了才进行解锁操作
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }


        }

    }
}


/**
 * 可中断
 */
class StopLock implements Runnable {

    public ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {

            //开启可中断锁，需要等待外部通知才会不进行排队等待
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "get lock");
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //判断如果当前线程拿到锁了才进行解锁操作
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }


        }
    }
}


/**
 * 可重入
 */
class ReenLock implements Runnable {

    public ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        /*
        锁的标准使用规范
        使用try-catch-finally
         */
        try {
            /*
            可重入
            一个线程针对同一个对象可以多次获得该对象的锁
            但是要确保锁几次就解锁几次，否则会出现死锁状况
            当前情况若finally中不作两次解锁操作，两个线程同时运行到该处会死锁
             */
            lock.lock();
            lock.lock();

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //无论前面会不会抛出异常，解锁操作都必须要在finally中执行
            //否则一旦前面出现异常会出现死锁状况出现
            lock.unlock();
            //lock.unlock();
        }


    }
}
