package com.galaxyt.copricorn.jdk8.thread;


import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 *  在高并发的情况下保证Long类型原子性
 *  性能会比AtomicLong更好
 *
 *
 * @author zhouqi
 * @date 2019-06-13 16:01
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 16:01     zhouqi          v1.0.0           Created
 *
 */
public class LongAdderTest {

    public static void main(String[] args) {

        LongAdder adder = new LongAdder();

        adder.add(1);

        System.out.println(adder.sum());


    }


}
