package com.zcc.design_pattern_practise.singleton_pattern;

/**
 * @author zcc
 * @ClassName SingletonTest
 * @description
 * @date 2021/6/16 19:40
 * @Version 1.0
 */

public class SingletonTest {
    public static void main(String[] args) {
        //非多线程下，Singleton2创建的单例可以正常
//        Singleton2 instance1 = Singleton2.getInstance();
//        Singleton2 instance2 = Singleton2.getInstance();
//        System.out.println(instance1.toString());
//        System.out.println(instance2.toString());
        //但是在多线程下，Singleton2 创建的单例就不正常了，可能2个线程都通过了if判断
//        new Thread(()->{
//            Singleton2 instance3 = Singleton2.getInstance();
//            System.out.println(instance3.toString());
//        }).start();
//
//        new Thread(()->{
//            Singleton2 instance4 = Singleton2.getInstance();
//            System.out.println(instance4.toString());
//        }).start();
//
//        new Thread(()->{
//            Singleton2 instance5 = Singleton2.getInstance();
//            System.out.println(instance5.toString());
//        }).start();

        //在多线程下，Singleton3 由于在getInstance方法加了synchronized ，所以每次只能有一个线程占有该方法，
        //就不会存在两个线程同时进入到if判断内了。但是实际上只需要在第一次创建该实例对象时加锁校验
        // （因为过了第一次，该实例对象已经被创建了，在内存中只有一个副本，其他调用getInstance()进入到if时，直接判为false，然后返回内存中的这个对象）
        new Thread(()->{
            Singleton3 instance3 = Singleton3.getInstance();
            System.out.println(instance3.toString());
        }).start();

        new Thread(()->{
            Singleton3 instance4 = Singleton3.getInstance();
            System.out.println(instance4.toString());
        }).start();

        new Thread(()->{
            Singleton3 instance5 = Singleton3.getInstance();
            System.out.println(instance5.toString());
        }).start();

    }
}
