package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信
 * Condition必须要和ReentrantLock一起使用
 * @author zhouqi
 * @date 2019-06-13 11:41
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 11:41     zhouqi          v1.0.0           Created
 *
 */
public class ReentrantLockConditionTest1 {


    public static void main(String[] args) {

        /*ObjectThread thread = new ObjectThread();

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (thread.object) {      //拿到该对象的所有权之后，程序会顺利结束，不会报错
            thread.object.notify();     //此时若没有拿到该对象的所有权会被报错，程序不会结束
        }*/


        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();


        new Thread(() -> {



            try {
                lock.lock();
                condition.await();  //执行等待
                System.out.println("stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.lock();
        condition.signal();     //此时当前没有锁的状态，需要先拿到锁再通知线程内部停止等待，最终再释放锁
        lock.unlock();


    }

}

class ObjectThread extends Thread {

    Object object = new Object();

    @Override
    public void run() {

        try {
            /*
            使用object的wait或notify方法的时候，必须要结合synchronized来使用
            必须要拿到该对象的所有权才能去这样作
             */
            synchronized (object) {

                object.wait();          //调用某个对象的wait()方法能让当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁）
                System.out.println("stop");

                //object.notify();      //调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的monitor，则只能唤醒其中一个线程；
                //object.notifyAll();     //调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程；
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
