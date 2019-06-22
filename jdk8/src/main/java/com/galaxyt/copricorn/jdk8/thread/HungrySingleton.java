package com.galaxyt.copricorn.jdk8.thread;

/**
 * 单例模式
 * 饿汉模式
 * 注：不管有没有调用getInstance()方法,都会预先在系统中创建一个静态对象
 * 优先：天生线程安全
 * 缺点：没有调用方法前就被加载，会占用内存
 *
 * @author zhouqi
 * @version v1.0.0
 * @date 2019-06-12 18:04
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2019-06-12 18:04     zhouqi          v1.0.0           Created
 */
public class HungrySingleton {


    //在初始化的时候实例化对象
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }


    public static HungrySingleton getInstance() {
        return instance;
    }


}
