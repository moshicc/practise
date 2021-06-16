package com.zcc.thread_practise.JUC.Demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName DataMethodLock
 * @description
 *
 * * 线程之间的通信问题：生产者和消费者问题！ 等待唤醒，通知唤醒
 * * 线程交替执行 A B 操作同一个变量 num = 0
 * * A num+1
 * * B num-1
 * @date 2021/6/16 10:29
 * @Version 1.0
 */

public class DataMethodLock {
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    //判断等待、业务、通知
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num = num + 1;
            System.out.println("当前线程是---->" + Thread.currentThread().getName() + " ----->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num ==0) {
                condition.await();
            }
            num = num - 1;
            System.out.println("当前线程是---->" + Thread.currentThread().getName() + " ----->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
