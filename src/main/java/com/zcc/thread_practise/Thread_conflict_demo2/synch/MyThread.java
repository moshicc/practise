package com.zcc.thread_practise.Thread_conflict_demo2.synch;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName MyThread
 * @description
 * @date 2021/6/3 11:18
 * @Version 1.0
 */

public class MyThread implements Runnable {

    Lock lock = new ReentrantLock();

    private static int count = 0;
    //对run方法加synchronized 也有不同的效果
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("进入run方法-----》" + t.getName());
        //doSomeLock();
    }
    /* *
     * @description: 在doSome 方法中，由于没有加锁，所以可能两个线程都进入到方法中，都走到for循环里的，
     * 所以线程1循环100次，线程2循环100次，而count是static类型，属于类变量，整个类共享的，两个线程谁取得cpu时间片时，
     * 谁就对count+1，所以就会出现两个线程交替对count+1，最终两个线程分别加了100次，count为200
     * @date 2021/6/3 19:55
     */
    private void doSome() {
        Thread t = Thread.currentThread();
        System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
            for (int i = 0; i < 100; i++) {
                count = count + 1;
                System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> count:" + count);
            }
        System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
    }
    /* *
     * @description: 在doSome方法中，由于只是对for用synchronized锁住了代码块，所以可能两个线程都进入了doSome1方法中，所以在最前面的step1都打印了，
     * 而两个线程将要进入for时，如果A先进去，那么就会A持有锁，只有等for循环100次结束后，才可以释放锁。之后B才能得到锁，进到for中.(大门是{}代码块)
     * 所以就会出现A先打印完100次，之后B再打印完100次
     * @date 2021/6/3 19:53
     */
    private void doSome1() {
        Thread t = Thread.currentThread();
        System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count = count + 1;
                System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> count:" + count);
            }
          //  System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
    }
    /* *
     * @description: 当对doSome加锁时，两个线程，同时只能有一个进到doSome里面。所以必须等1个执行完doSome里面的所有的，另外一个才能执行。
     * （大门是doSome2方法）
     * @date 2021/6/3 20:21
     */
    private synchronized void doSome2() {
        Thread t = Thread.currentThread();
        System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
            for (int i = 0; i < 100; i++) {
                count = count + 1;
                System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> count:" + count);
            }
        System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
    }
    /* *
     * @description:修饰整个类
     * @date 2021/6/4 11:08
     */
    private synchronized void doSome3() {
        synchronized (MyThread.class) {
            Thread t = Thread.currentThread();
            System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
            for (int i = 0; i < 100; i++) {
                count = count + 1;
                System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> count:" + count);
            }
            System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
        }
    }
    /* *
     * @description: 因为这个a不是共享变量，（仅为doSome4方法的局部变量，作用域仅在该方法内部）。所以，多线程时，每个线程内部都有一个a的副本，所以我们看到的，两个线程只对自己线程内的a进行+1
     * 所以最终，每个线程内部的a都从0加到100 打印出来。
     * @date 2021/6/4 11:15
     */
    private void doSome4() {
        int a = 0;
        Thread t = Thread.currentThread();
        System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
        for (int i = 0; i < 100; i++) {
            a = a + 1;
            System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> a:" + a);
        }
        System.out.println("线程："+t.getName()+"执行完了，最终a：" +a);
    }
    /* *
     * @description: 采用Lock的方式试试
     * @date 2021/6/4 14:04
     */
    private void doSomeLock() {
        lock.lock();
        Thread t = Thread.currentThread();
        System.out.println("step1:当前进入doSome 方法的是线程------->" + t.getName());
        for (int i = 0; i < 100; i++) {
            count = count + 1;
            System.out.println("当前进入for循环内的线程是：" + t.getName() +"----第"+i+"次"+ "---------> count:" + count);
        }
        System.out.println("线程："+t.getName()+"执行完了，最终count：" +count);
        //一般把unlock解锁放到 finally里面，防止程序出现异常，一个线程一直持有锁
        lock.unlock();
    }



}
