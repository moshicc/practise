package com.zcc.thread_practise.JUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName Lock8Test1
 * @description
 * *
 * * 8锁，就是关于锁的8个问题
 * * 1、标准情况下，两个线程先打印 发短信还是 打电话？ 1/发短信 2/打电话
 * * 2、sendSms延迟4秒，两个线程先打印 发短信还是 打电话？ 1/发短信 2/打电话 (先发短信，4秒后打电话)
 * @date 2021/6/17 10:02
 * @Version 1.0
 */

public class Lock8Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            System.out.println("当前执行的线程是:" +Thread.currentThread().getName());
            phone.sendSms();
        },"A").start();

        try {
            //睡眠1秒，让线程A先执行
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("当前执行的线程是:" +Thread.currentThread().getName());
            phone.call();
        },"B").start();
    }
}

class Phone{
    // synchronized 锁的对象是方法的调用者！（调用者是phone这个对象，所以同一时刻只能有一个线程持有phone对象）当然如果是两个不同的对象p1，p2,就不会竞争了
    // 两个方法用的是同一个锁，谁先拿到谁执行！
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
