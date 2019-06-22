package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.locks.StampedLock;

/**
 * 加强版的读写锁
 * @author zhouqi
 * @date 2019-06-13 16:05
 * @version v1.0.0
 * @Description 
 * 
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 16:05     zhouqi          v1.0.0           Created
 *
 */
public class StampedLockTest {


    public static void main(String[] args) {


        StampedLock lock = new StampedLock();

        lock.asReadLock().lock();
        lock.asReadLock().unlock();


        
    }
    
    
}
