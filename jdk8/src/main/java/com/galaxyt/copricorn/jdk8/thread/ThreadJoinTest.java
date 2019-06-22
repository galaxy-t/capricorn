package com.galaxyt.copricorn.jdk8.thread;

/**
 * 等待线程执行完成
 * @author zhouqi
 * @date 2019-06-12 15:47
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 15:47     zhouqi          v1.0.0           Created
 *
 */
public class ThreadJoinTest {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("数据保存成功");

        });

        thread.start();

        try {

            //将thread线程插入到当前线程来执行，等待thread线程执行完成再往后面进行
            //thread.join();

            //为thread等待0.5秒时间，然后往后面进行
            thread.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("=================");


    }



}
