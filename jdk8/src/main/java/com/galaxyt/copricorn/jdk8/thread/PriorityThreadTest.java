package com.galaxyt.copricorn.jdk8.thread;

/**
 * 线程优先级
 * 设置线程优先级并不是强制性的执行顺序
 * 仅仅代表有可能会按照高低顺序执行，具体还需要看CPU调度情况
 * @author zhouqi
 * @date 2019-06-12 16:46
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 16:46     zhouqi          v1.0.0           Created
 *
 */
public class PriorityThreadTest {


    public static void main(String[] args) {

        Thread t1 = new Thread3("t1");
        Thread t2 = new Thread3("t2");


        //为线程设置优先级，并不能保证真实执行情况一定是这样
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);


        t2.start();
        t1.start();

    }


}


class Thread3 extends Thread {

    public Thread3(String name) {
        super.setName(name);
    }


    static int count = 100;


    @Override
    public void run() {

        while (true) {
            synchronized (Thread3.class) {
                count++;

                if (count > 100) {

                    System.out.println(Thread.currentThread().getName() + "线程结束了");

                    break;
                }
            }
        }


    }
}
