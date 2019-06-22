package com.galaxyt.copricorn.jdk8.thread;

/**
 * 单例模式
 * 懒汉模式
 * 注：在第一次调用getInstance方法的时候创建实例
 * 缺点：在多线程的情况下线程不安全，需要自行解决该问题
 * 优点：不会预先创建对象，节省内存控件，只有当用到的情况下才会创建对象
 * @author zhouqi
 * @date 2019-06-12 17:52
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-12 17:52     zhouqi          v1.0.0           Created
 *
 */
public class LazySingleton {


    //1
    //若不加volatile关键字，在多线程并发的情况下会出现问题
    //但是单纯加volatile关键字也是不能够解决问题的，仅能保证该对象被实例化后立刻被内存发现
    private static volatile LazySingleton instance = null;

    private LazySingleton() {

    }


    //4
    //最安全的办法是在该方法上加锁
    //但是会影响并发速度
    public static LazySingleton getInstance() {

        if (instance == null) {

            //2
            //将初始化方法加锁
            //锁只能保证多线程执行的有序性
            //加入又a,b,c三个线程同时完成了第一个判断进入到此处
            //a线程先拿到锁，然后new了一次
            //b线程又拿到锁，又进行new了一次
            //。。。
            synchronized (LazySingleton.class) {

                //3
                //Double Check
                //双重检查
                //此时才能保证当前代码为懒加载的单例模式
                if (instance == null) {
                    instance = new LazySingleton();
                }

            }


        }

        return instance;
    }

}
