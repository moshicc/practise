package com.zcc.thread_practise.JUC.AQS.MyLock;

import com.zcc.reflect_practise.Person;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName MyLock3
 * @description
 * @date 2021/10/14 16:04
 * @Version 1.0
 */

public class MyLock3 {
    public static void main(String[] args) throws InterruptedException {
        Person p1 = new Person();
        Person p2 = new Person();

        Lock lock = new ReentrantLock();

        new Thread(()->{
            try {
                lock.lock();
                //执行业务
                System.out.println(Thread.currentThread().getName() + "--> 获取到对象：" + p1);

            } finally {
                //释放锁
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {

                }finally {
                    lock.unlock();
                }
            }

        },"线程1号").start();

        new Thread(()->{
            try {
                lock.lock();
                //执行业务
                System.out.println(Thread.currentThread().getName() + "--> 获取到对象：" + p1);

            } finally {
                lock.unlock();
            }
        },"线程2号").start();



    }
}
