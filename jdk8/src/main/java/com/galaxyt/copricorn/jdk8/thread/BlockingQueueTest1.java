package com.galaxyt.copricorn.jdk8.thread;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 * @author zhouqi
 * @date 2019-06-13 14:26
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 14:26     zhouqi          v1.0.0           Created
 *
 */
public class BlockingQueueTest1 {

    //初始化并设置该队列长度为100
    static BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);


    public static void main(String[] args) {

        new Thread(() -> {

            while (true) {

                try {
                    //Thread.sleep(3000);

                    queue.add(UUID.randomUUID().toString());
                    System.out.println("add success");

                } /*catch (InterruptedException e) {
                    e.printStackTrace();
                }*/ catch (IllegalStateException e) {   //在队列超长的时候会报错，捕捉到这个错误，然后继续往里面放值

                }


            }

        }).start();

        new Thread(() -> {

            while (true) {
                try {
                    //阻塞方法
                    String result = queue.take();
                    System.out.println(result);

                    Thread.sleep(3000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }).start();

    }


}
