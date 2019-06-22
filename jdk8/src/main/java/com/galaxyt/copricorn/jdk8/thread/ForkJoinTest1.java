package com.galaxyt.copricorn.jdk8.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 * 将任务拆分成多个子任务，一级一级拆分，直到ForkJoin认为不需要Fork之后才会去执行并拿到结果，然后再Join成一个最终的结果
 *
 * RecursiveAction  用于任务没有返回值的场景
 * RecursiveTask    用于任务又返回值的场景
 *
 * @author zhouqi
 * @date 2019-06-13 15:26
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-13 15:26     zhouqi          v1.0.0           Created
 *
 */
public class ForkJoinTest1 {


    public static void main(String[] args) {


        ForkJoinPool pool = new ForkJoinPool();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }

        ForkJoinTask<Integer> task = pool.submit(new RecursiveTaskTest(list, list.size(), 0));


        System.out.println(task.join());

        pool.shutdown();



    }


}



class RecursiveTaskTest extends RecursiveTask<Integer> {

    //模拟业务需要的数据
    private List<String> list;

    //要处理的任务的大小
    //RecursiveTask的size
    private int length;

    //任务开始的位置
    private int start;


    public RecursiveTaskTest(List<String> list, int length, int start) {
        this.list = list;
        this.length = length;
        this.start = start;
    }

    @Override
    protected Integer compute() {

        Integer sum = 0;

        if (length < 4) {
            for (int i = start; i < start + length; i++) {
                sum += count(list.get(i));
            }

            return sum;
        } else {

            Integer sum2 = 0;

            List<RecursiveTaskTest> taskList = new ArrayList<>();

            int split = length/2;
            taskList.add(new RecursiveTaskTest(list, split, start));
            taskList.add(new RecursiveTaskTest(list, length - split, start + split));

            Collection<RecursiveTaskTest> collection = invokeAll(taskList);


            for (RecursiveTaskTest rtt : collection) {
                try {
                    sum2 += rtt.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            return sum2;
        }



    }

    public Integer count(String string) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(string + "===");

        return 1;


    }


}
