package com.zcc.thread_practise.JUC.Demo1;

/**
 * @author zcc
 * @ClassName DataMethodSyn
 * @description
 * @date 2021/6/16 10:09
 * @Version 1.0
 */

public class DataMethodSyn {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num = num + 1;
        System.out.println("当前线程是---->" + Thread.currentThread().getName() + " ----->" + num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num ==0) {
            this.wait();
        }
        num = num - 1;
        System.out.println("当前线程是---->" + Thread.currentThread().getName() + " ----->" + num);
        this.notifyAll();
    }
}
