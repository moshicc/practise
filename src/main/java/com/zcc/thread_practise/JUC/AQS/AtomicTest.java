package com.zcc.thread_practise.JUC.AQS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zcc
 * @ClassName AtomicTest
 * @description  开3条线程，从0累加到10000，打印结果
 * @date 2021/10/13 9:50
 * @Version 1.0
 */

public class AtomicTest {

    static  int count = 0;

    static AtomicInteger count1 = new AtomicInteger();

    public static void main(String[] args) {
        errorThread();
        //atomicThread();
    }
    //无任何加锁，当3个线程同时访问共享资源count时，会出现不同步情况。
    //比如线程A得到count为999，通过while条件。再还没进行++时，线程B得到count值也为9999，也通过while条件（或者说count++后，还没刷新到主存中）
    public static void errorThread() {
        AtomicTest atomicTest = new AtomicTest();

        //3条线程
        for (int i = 0; i < 3; i++) {
            new Thread(() ->{
                atomicTest.method();

            }).start();
        }
    }


    public static void atomicThread() {
        //3条线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (count1.get() <1000) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程："+Thread.currentThread().getName()+" -->count:" + count1.getAndIncrement());

                }
            }).start();
        }
    }

    public synchronized void method () {
            while (count < 1000) {

                System.out.println("当前线程："+Thread.currentThread().getName()+" -->count:" + count++);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
