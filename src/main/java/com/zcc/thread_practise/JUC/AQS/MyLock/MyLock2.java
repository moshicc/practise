package com.zcc.thread_practise.JUC.AQS.MyLock;

import com.zcc.reflect_practise.Person;

/**
 * @author zcc
 * @ClassName MyLock2
 * @description  两个线程持有A、B 两个对象锁，并且想要 获得 B 、A 对象锁。因此发生了死锁。 synchronized
 * @date 2021/10/14 15:29
 * @Version 1.0
 */

public class MyLock2 {
    public static void main(String[] args) {
        //自己随便创建个对象.....
        Person p1 = new Person();
        Person p2 = new Person();

        new Thread(()->{
            //获取p1对象锁
            synchronized (p1) {
                System.out.println(Thread.currentThread().getName() + "-->获取到p1");
                try {
                    //不释放p1的情况下，睡眠2秒，再获取p2对象锁（意图是让另外个线程有时间先获取p2）
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (p2) {
                    System.out.println(Thread.currentThread().getName() + "-->获取到p2");
                }
            }
        },"线程1号").start();

        try {
            //睡眠0.5秒，让 线程1 先执行
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            //获取p2对象锁
            synchronized (p2) {
                System.out.println(Thread.currentThread().getName() + "-->获取到p2");
                synchronized (p1) {
                    System.out.println(Thread.currentThread().getName() + "-->获取到p1");
                }
            }
        },"线程2号").start();
    }
}

/* *
-----------------------------------------------------------
线程2号：持有 0x00000000d5ebb948 ，想要 0x00000000d5ebb930
线程1号：持有 0x00000000d5ebb930 ，想要 0x00000000d5ebb948
-----------------------------------------------------------

Found one Java-level deadlock:
=============================
"线程2号":
  waiting to lock monitor 0x00000000031ba658 (object 0x00000000d5ebb930, a com.zcc.reflect_practise.Person),
  which is held by "线程1号"
"线程1号":
  waiting to lock monitor 0x00000000031bba48 (object 0x00000000d5ebb948, a com.zcc.reflect_practise.Person),
  which is held by "线程2号"

Java stack information for the threads listed above:
===================================================
"线程2号":
	at com.zcc.thread_practise.JUC.AQS.MyLock.MyLock2.lambda$Main$1(MyLock2.java:46)
	- waiting to lock <0x00000000d5ebb930> (a com.zcc.reflect_practise.Person)
	- locked <0x00000000d5ebb948> (a com.zcc.reflect_practise.Person)
	at com.zcc.thread_practise.JUC.AQS.MyLock.MyLock2$$Lambda$2/931919113.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)
"线程1号":
	at com.zcc.thread_practise.JUC.AQS.MyLock.MyLock2.lambda$Main$0(MyLock2.java:29)
	- waiting to lock <0x00000000d5ebb948> (a com.zcc.reflect_practise.Person)
	- locked <0x00000000d5ebb930> (a com.zcc.reflect_practise.Person)
	at com.zcc.thread_practise.JUC.AQS.MyLock.MyLock2$$Lambda$1/1828972342.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:748)

Found 1 deadlock.
 */
