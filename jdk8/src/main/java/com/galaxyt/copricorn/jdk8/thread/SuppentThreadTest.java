package com.galaxyt.copricorn.jdk8.thread;

/**
 * 线程挂起示例
 * 已不推荐使用
 * @author zhouqi
 * @date 2019-06-12 16:26
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 16:26     zhouqi          v1.0.0           Created
 *
 */
public class SuppentThreadTest {

    public static void main(String[] args) {

        Thread2 thread2 = new Thread2("t1");
        Thread2 thread3 = new Thread2("t2");

        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();

        //取消挂起thread2
        thread2.resume();

        //等待一秒再将thread3取消挂起就会能够解决t3一直无法取消挂起
        //但并不能保证这一秒thread3真的就能启动运行并进入挂起状态
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        thread3.resume();


        //最终状态是t3线程一直在挂起状态，使用jstack查看可得
        //原因是在thread3启动之后在很短的时间内又将thread3取消挂起，但是这段时间之内thread3线程并没有进行挂起操作导致取消挂起失败
        //所以thread3线程一直保持在挂起状态

    }




}

class Thread2 extends Thread {

    public Thread2(String name) {
        super.setName(name);

    }


    @Override
    public void run() {

        synchronized (Thread2.class) {
            System.out.println(getName());
            //挂起当前线程
            Thread.currentThread().suspend();
        }

    }
}

