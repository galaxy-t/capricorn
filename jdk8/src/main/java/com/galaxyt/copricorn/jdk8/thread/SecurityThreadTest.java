package com.galaxyt.copricorn.jdk8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 保证线程安全
 * @author zhouqi
 * @date 2019-06-12 17:08
 * @version v1.0.0
 * @Description
 *  注：
 *      原子性
 *          保证操作的连续性，如a++,要保证读取变量a的值，a的值+1，将值赋予变量a，要保证三个操作不能被篡改
 *      可见行
 *          与原子性类似，保证对象在修改之后立刻在内存中可见
 *      有序性
 *          happens-before原则，在JMM中，如果一个操作执行的结果需要对另一个操作可见，那么这两个操作之间必须存在happens-before关系。
 *          1. 如果一个操作happens-before另一个操作，那么第一个操作的执行结果将对第二个操作可见，而且第一个操作的执行顺序排在第二个操作之前。
 *          2. 两个操作之间存在happens-before关系，并不意味着一定要按照happens-before原则制定的顺序来执行。如果重排序之后的执行结果与按照happens-before关系来执行的结果一致，那么这种重排序并不非法。
 *
 *          程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作；
 *          锁定规则：一个unLock操作先行发生于后面对同一个锁额lock操作；
 *          volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作；
 *          传递规则：如果操作A先行发生于操作B，而操作B又先行发生于操作C，则可以得出操作A先行发生于操作C；
 *          线程启动规则：Thread对象的start()方法先行发生于此线程的每个一个动作；
 *          线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生；
 *          线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行；
 *          对象终结规则：一个对象的初始化完成先行发生于他的finalize()方法的开始；
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 17:08     zhouqi          v1.0.0           Created
 *
 */
public class SecurityThreadTest {

    //默认情况下数据丢失的比较严重，预期最终结果为100000，但实际情况只有五六万左右
    //public static int a = 0;

    //添加volatile关键字也仅仅是情况稍微好一点，但误差还是很大
    public static volatile int a = 0;


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {

            executorService.execute(() -> {

                for (int j = 0; j < 10000; j++) {
                    SecurityThreadTest.a++;

                }


            });

        }

        executorService.shutdown();


        while (executorService.isTerminated()) {
            break;
        }

        System.out.println(SecurityThreadTest.a);

    }




}


/**
 * 假设又两个线程A,B，A线程执行set方法，B线程执行get方法
 * 在JVM对代码进行重排序之后，set方法中的两行代码可能先执行flag=true再执行count = 1
 * 当A线程先执行完了flag=true之后，B线程执行get方法，此时count=0，B线程得到的结果为1
 */
class Num {


    int count = 0;

    boolean flag = false;

    public void set() {
        count = 1;
        flag = true;
    }

    public void get() {
        if (flag) {
            int b = count + 1;

            System.out.println(b);
        }
    }


}

