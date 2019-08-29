package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏类
 * 用于阻塞线程，当线程到达栅栏位置的时候调用其 await 方法，知道栅栏阻塞的线程到达预先指定的数量后再开始执行
 * @author zhouqi
 * @date 2019-08-29 10:47
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-08-29 10:47     zhouqi          v1.0.0           Created
 *
 */
public class CyclicBarrierTest {


    // 自定义工作线程
    private static class Worker extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            super.run();

            try {
                System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "开始执行");
                // 工作线程开始处理，这里用Thread.sleep()来模拟业务处理
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            System.out.println("创建工作线程" + i);
            Worker worker = new Worker(cyclicBarrier);
            worker.start();
        }
    }



}
