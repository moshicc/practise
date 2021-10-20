package com.zcc.thread_practise.threadLocal;

/**
 * @author zcc
 * @ClassName ThreadLocalTest01
 * @description 创建一个ThreadLocal对象，再创建3条线程，在这3条线程内对这个threadLocal对象进行get、set操作。观察。
 * 得出结论，虽然这个ThreadLocal设置的是全局的静态变量。但是这个对象针对于每个线程是互相隔离的，A线程set的值，只会在A线程中获取的到。不会影响到B线程中的值
 * @date 2021/10/20 9:32
 * @Version 1.0
 */

public class ThreadLocalTest01 {
    private static ThreadLocal<String> localStr = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
            localStr.set("张三");
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
       },"线程A");
       t1.start();

      Thread t2 =  new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
            localStr.set("李四");
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
        },"线程B");
      t2.start();

      Thread t3 =  new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
            localStr.set("王五");
            System.out.println(Thread.currentThread().getName() +"的localStr值是:" + localStr.get());
        },"线程C");
      t3.start();
    }
}
