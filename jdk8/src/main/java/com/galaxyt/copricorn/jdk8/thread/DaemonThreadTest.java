package com.galaxyt.copricorn.jdk8.thread;

/**
 * 守护线程
 * @author zhouqi
 * @date 2019-06-12 16:58
 * @version v1.0.0
 * @Description
 *  JAVA中分为两种线程
 *      1：用户线程
 *          MainThread
 *          WorkerThread
 *      2：守护线程
 *
 *      守护线程仅当当前用户线程存在的时候会存在，若全部的用户线程没有了，该守护线程也会被一起销毁
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 16:58     zhouqi          v1.0.0           Created
 *
 */
public class DaemonThreadTest {


    public static void main(String[] args) {


        Thread thread = new Thread(() -> {

            while (true) {
                System.out.println("=====");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        thread.setName("ttttttttt");

        thread.setDaemon(true);

        thread.start();


    }


}
