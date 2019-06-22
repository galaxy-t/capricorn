package com.galaxyt.capricorn.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 分布式锁
 * @author zhouqi
 * @date 2019-06-18 17:24
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-18 17:24     zhouqi          v1.0.0           Created
 *
 */
public class LockTest {

    static int count = 2;


    public static void main(String[] args) {


        //重试策略，初试时间为1秒，重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,10);


        //通过工场创建连接
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .sessionTimeoutMs(1000 * 10)
                .retryPolicy(retryPolicy)
                .build();

        //开启连接
        cf.start();


        final InterProcessMutex lock = new InterProcessMutex(cf,"/mylock");
        final CountDownLatch latch = new CountDownLatch(1);

        ExecutorService pool = Executors.newFixedThreadPool(40);

        for (int i = 0; i < 40; i++) {


            pool.execute(() -> {

                System.out.println(1);

                try {
                    //当前latch为1，所有线程进行预加载，等待全部放入线程池中
                    latch.await();

                    //获得分布式锁的许可
                    lock.acquire();

                    Thread.sleep(100);

                    //synchronized (LookTest.class) {
                        if (count > 0) {
                            count--;
                            //用完之后释放锁
                            lock.release();
                            System.out.println("===" + count);
                        }
                    //}


                } catch (Exception e) {
                    e.printStackTrace();
                }


            });


        }

        System.out.println("开始执行了");

        //放行全部线程
        latch.countDown();

        pool.shutdown();

    }


}
