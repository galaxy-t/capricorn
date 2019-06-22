package com.galaxyt.copricorn.jdk8.thread;

/**
 * 静态方法加锁
 * 类锁
 * 同一个类中的加锁静态方法公用一把锁，这些方法之间互斥
 * @author zhouqi
 * @date 2019-06-13 09:43
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 09:43     zhouqi          v1.0.0           Created
 *
 */
public class SynchronizedTest1 {


    public static void main(String[] args) {

        new Thread(() -> {
            hello1();
        }).start();

        new Thread(() -> {
            hello2();
        }).start();


    }


    public synchronized static void hello1() {
        System.out.println("start1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end1");
    }


    public synchronized static void hello2() {

        System.out.println("start2");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end2");


    }


}
