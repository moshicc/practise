package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName SemaphoreDemo
 * @description 一个计数信号量。 在概念上，信号量维持一组许可证。
 * 如果有必要，每个acquire()都会阻塞，直到许可证可用，然后才能使用它。
 * 每个release()添加许可证，潜在地释放阻塞获取方。
 * 但是，没有使用实际的许可证对象; Semaphore只保留可用数量的计数，并相应地执行。
 *
 * semaphore.acquire() 获得，假设如果已经满了，等待，等待被释放为止！
 * semaphore.release(); 释放，会将当前的信号量释放 + 1，然后唤醒等待的线程！
 * 作用： 多个共享资源互斥的使用！并发限流，控制最大的线程数！
 * @date 2021/6/21 20:08
 * @Version 1.0
 */

public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数量，停车位
        Semaphore semaphore = new Semaphore(3);

        for (int i= 0; i < 6; i++) {
            new Thread(()->{
                //得到许可
                try {
                    //得到许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                            TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(); // 释放
                }
            },String.valueOf(i)).start();
        }

    }
}
