package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 在不改变数据类型的情况下，保证变量的原子性
 * @author zhouqi
 * @date 2019-06-13 11:51
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 11:51     zhouqi          v1.0.0           Created
 *
 */
public class AtomicReferenceTest {

    public static String str = "abcd";

    public static AtomicReference<String> strRef = new AtomicReference<String>("abcd");


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(500);

        for (int i = 0; i < 500; i++) {
            executorService.execute(() -> {

                if (strRef.compareAndSet("abcd", "efgh")) { //先判断再修改并且返回boolean类型
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }

                if (str.equals("abcd")) {
                    str = "efgh";
                    System.out.println("update success");
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println(str);
        System.out.println(strRef.get());

    }



}
