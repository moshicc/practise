package com.zcc.thread_practise.JUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName Lock8Test4
 * @description
 * * 1、1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话？ 打电话
 * * 2、1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话？ 打电话
 * （因为两个线程锁的都不是同一个东西，所以不存在竞争锁的问题）
 * new this 具体的一个手机
 * static Class 唯一的一个模板
 * @date 2021/6/17 11:55
 * @Version 1.0
 */

public class Lock8Test4 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(()->{
            System.out.println("当前执行的线程是:" +Thread.currentThread().getName());
            phone1.sendSms();
        },"A").start();

        try {
            //睡眠1秒，让线程A先执行
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("当前执行的线程是:" +Thread.currentThread().getName());
            phone2.call();
        },"B").start();
    }
}

class Phone4{
    // synchronized 锁的对象是方法的调用者！、
    // static 静态方法
    // 类一加载就有了！锁的是Class

    public static synchronized void sendSms() {
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
