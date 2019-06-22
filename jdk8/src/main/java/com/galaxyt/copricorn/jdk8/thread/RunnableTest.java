package com.galaxyt.copricorn.jdk8.thread;

/**
 * Runnable实现多线程方式示例
 * @author zhouqi
 * @date 2019-06-12 15:26
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 15:26     zhouqi          v1.0.0           Created
 *
 * 状态：
 *      New：还没启动，刚被实例化
 *      Runnable：就绪状态，调用start方法之后进入该状态，等待CPU调度
 *      Running：运行状态，正在执行线程中代码
 *
 *      Blocked：阻塞状态，线程进入运行状态后，可能由于多种原因让线程进入阻塞状态，如：调用sleep()方法让线程睡眠，调用wait()方法让线程等待，调用join()方法、suspend()方法（它现已被弃用！）以及阻塞式IO方法。
 *              Waiting：等待状态，等待被唤醒，Object.wait()  Thread.join()
 *              Timed_Waiting:即使等待，Thread.sleep()
 *      Dead：结束状态
 *
 *
 */
public class RunnableTest {

    public static void main(String[] args) {

        Runnable runnable = new Runnable1();

        Thread thread = new Thread(runnable);

        thread.start();

        System.out.println("=============");

        new Thread(() -> {

            System.out.println("Lambda方式实现");

        }).start();

    }

}

class Runnable1 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据保存");
    }
}
