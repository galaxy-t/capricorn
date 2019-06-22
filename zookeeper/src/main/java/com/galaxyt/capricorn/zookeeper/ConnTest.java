package com.galaxyt.capricorn.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * 原始链接方式
 * @author zhouqi
 * @date 2019-06-18 16:10
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-18 16:10     zhouqi          v1.0.0           Created
 *
 */
public class ConnTest {


    public static void main(String[] args) {

        try {
            /*
            args1:地址加端口，若集群的情况以逗号分割
            args2:session过期时间，毫秒值，这个值的之间内没有心跳成功则判定session断开
            args3:时间监听
             */
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 1000 * 10, null);

            /*
            创建一个节点
            args1:节点名称
            args2:节点值
            args3:权限，此处设置为全部人
            args4:节点类型，此处设置为持久化，其他还有持久化带版本号类型，会话类型，会话带版本号类型
            也可以选择其它的重载方法设置回调、监听等
             */
            //zooKeeper.create("/connTest", "connTestContent".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


            byte[] result = zooKeeper.getData("/connTest", false, new Stat());

            System.out.println(new String(result));

            /*
            删除节点
            args1：节点名称
            args2：版本号，-1为忽略版本号
             */
            //zooKeeper.delete("/connTest", -1);

            //得到一个目录下的所有的子节点
            //zooKeeper.getChildren()


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }



}
