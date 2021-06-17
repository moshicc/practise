package com.zcc.thread_practise.JUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName Lock8Test2
 * @description
 * * 3、 增加了一个普通方法后！先执行发短信还是Hello？ 普通方法hello
 * * 4、 两个对象，两个同步方法， 发短信还是 打电话？  打电话
 * (当两个对象时，每个线程分别锁住一个对象，所以互不影响。先线程A 执行phone1方法,锁住phone1对象，睡眠4秒，sheep1秒后
 * 线程B 执行phone2 方法，锁住phone2对象，打印打电话，4秒睡完后，线程A打印 发短信)
 * @date 2021/6/17 10:21
 * @Version 1.0
 */

public class Lock8Test2 {
    public static void main(String[] args) {
        //两个对象，像个调用者，两把锁，所以双方不受影响
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

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

class Phone2{
    // synchronized 锁的对象是方法的调用者！、
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
    //没加synchronized ，这里没有锁！不是同步方法，不受锁的影响（）
    public void hello() {
        System.out.println("hello");
    }

}
