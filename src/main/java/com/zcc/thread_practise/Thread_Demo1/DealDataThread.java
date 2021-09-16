package com.zcc.thread_practise.Thread_Demo1;

/**
 * @author zcc
 * @ClassName DealDataThread
 * @description
 * @date 2021/9/16 16:23
 * @Version 1.0
 */

public class DealDataThread implements Runnable {
    //每次打印的次数
    int n;

    public DealDataThread(int n) {
        this.n = n;
    }

    public DealDataThread() {
    }

    @Override
    public void run() {
        print(n);
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " ---> " + i);
        }
    }
}
