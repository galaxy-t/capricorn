package com.galaxyt.capricorn.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.proto.WatcherEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CuratorTest {


    public static void main(String[] args) throws Exception {


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

        /*
        creatingParentsIfNeeded:递归创建，若父节点不存则创建父节点

         */
        //cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/zhouqi/test1", "测试内容".getBytes());

        //System.out.println(new String(cf.getData().forPath("/zhouqi/test1")));

        //cf.setData().forPath("/zhouqi/test1", "哈哈哈修改了".getBytes());

        //System.out.println(new String(cf.getData().forPath("/zhouqi/test1")));

        //cf.delete().guaranteed().deletingChildrenIfNeeded().forPath("/zhouqi");




        /*if (cf.checkExists().forPath("/tt") == null) {
            cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/tt", "tt".getBytes());
        }

        //节点监听器仅能生效一次，第二次修改不会生效
        byte[] result = cf.getData().usingWatcher(new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("节点监听器" + event.getType().getIntValue() + "\t" + event.getPath());
            }
        }).forPath("/tt");

        System.out.println(new String(result));*/




        /*
        使用线程池
        将每次监听的操作放入线程池中操作
        可以持续监听
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        NodeCache nodeCache = new NodeCache(cf, "/tt", false);

        nodeCache.start(true);

        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {


                System.out.println(nodeCache.getCurrentData().getPath() + "数据修改了，新的数据是:"
                + new String(nodeCache.getCurrentData().getData()));

            }
        }, executorService);


        Thread.sleep(Integer.MAX_VALUE);

    }



}
