package com.zcc.thread_practise.JUC.AQS.MyLock;

import com.zcc.reflect_practise.Person;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zcc
 * @ClassName MyLock
 * @description 可重入锁指一个线程可以多次对同一个对象进行加锁（前次加锁还没释放，就可以再次加锁）
 * 条件：必须是同一个线程 对同一个对象。synchronized 和 lock （state变量维护）都是可重入锁
 * @date 2021/10/14 13:41
 * @Version 1.0
 */

public class MyLock1 {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //获得person对象锁
                synchronized (person) {

                    try {
                        //进入wating状态，让出对象锁
                        person.wait();
                        //睡一会，慢点
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count = count + 1;
                    System.out.println("当前线程："+ Thread.currentThread().getName()+"-->第：" + count + "次获得：" + person.toString() + "的对象锁");
                    //只要没出这个synchronized 就是当前线程还没有释放这个person的对象锁，此时再次尝试获取锁
                    synchronized (person) {
//                        try {
//                            //睡一会，慢点
//                            Thread.sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        count = count + 1;
                        System.out.println("当前线程："+ Thread.currentThread().getName()+"-->第：" + count + "次获得：" + person.toString() + "的对象锁");
                        try {
                            person.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        },"线程1号").start();
        //主线程睡眠几秒，确保线程1 先于 线程2 运行
        Thread.sleep(100);

        //第二个线程
        new Thread(()->{
            //线程二号想要获取person对象，必须要线程1号释放后
            synchronized (person) {
                count = count + 1;
                System.out.println("当前线程："+ Thread.currentThread().getName()+"-->第：" + count + "次获得：" + person.toString() + "的对象锁");
                person.notifyAll();
            }
        },"线程2号").start();


        //10秒后再唤醒一次
        Thread.sleep(10000);
        synchronized (person) {
            // notify 和 wait 必须再同步代码块里才可以使用。即该线程进入montor，获得了对象锁，才可以调用这两个方法
            person.notify();
        }
    }


}
