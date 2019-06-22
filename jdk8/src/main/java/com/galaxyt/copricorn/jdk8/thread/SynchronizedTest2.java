package com.galaxyt.copricorn.jdk8.thread;



/**
 * 非静态方法上加锁
 * 对象锁
 * 在同一个对象中，不同的加锁非静态方法公用一把锁，这些方法之间互斥
 * 静态块效果一样，只不过粒度更小
 *      同步代码块括号中设置的对象称为监视器对象
 *      示例 SynchronizedTest2.class  this    变量
 *      SynchronizedTest2.class  表示同步强调的是类，此时的效果跟加在静态方法上的效果一样
 *      this    表示同步强调的是调用该方法的对象，此时的效果跟加在非静态方法上的效果一样
 *      变量      分为静态变量和非静态变量两种
 *             静态变量     全局锁住
 *             非静态变量    为拥有该非静态变量的对象加锁
 *
 * @author zhouqi
 * @date 2019-06-13 09:42
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 09:42     zhouqi          v1.0.0           Created
 *
 */
public class SynchronizedTest2 {

    public synchronized void hello1() {
        System.out.println("start1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end1");
    }


    public synchronized void hello2() {
        System.out.println("start2");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end2");
    }




    public static void main(String[] args) {

        SynchronizedTest2 test1 = new SynchronizedTest2();
        SynchronizedTest2 test2 = new SynchronizedTest2();

        new Thread(() -> {
            test1.hello1();
        }).start();

        new Thread(() -> {
            test1.hello2();
        }).start();


        new Thread(() -> {
            test2.hello1();
        }).start();

        new Thread(() -> {
            test2.hello2();
        }).start();



    }



}
