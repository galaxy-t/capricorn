package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.*;

/**
 * 使用线程池拿到线程的返回结果
 * @author zhouqi
 * @date 2019-06-13 16:19
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 16:19     zhouqi          v1.0.0           Created
 *
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                Thread.sleep(1000);

                return "result";
            }
        };

        FutureTask<String> task = new FutureTask<>(callable);

        executorService.submit(task);

        System.out.println(task.get());

        executorService.shutdown();

    }


}
