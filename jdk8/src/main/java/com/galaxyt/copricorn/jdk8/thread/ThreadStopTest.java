package com.galaxyt.copricorn.jdk8.thread;

/**
 * 线程中断示例
 * @author zhouqi
 * @date 2019-06-12 15:55
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 15:55     zhouqi          v1.0.0           Created
 *
 */
public class ThreadStopTest {


    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            while (true) {

                //判断外部是否要求本线程作出停止动作
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //在抛出异常后，要求中断的标记会被清除，无法达到停止线程的操作
                    //需要重新设置中断标记进行停止
                    Thread.currentThread().interrupt();

                }

                System.out.println("========");
            }


        });


        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //直接强制关闭该线程，已过时
        //thread.stop();

        //通知线程内部要求其停止，达到优雅关机
        thread.interrupt();

    }


}
