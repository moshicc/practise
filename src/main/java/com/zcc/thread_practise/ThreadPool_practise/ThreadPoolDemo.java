package com.zcc.thread_practise.ThreadPool_practise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zcc
 * @ClassName ThreadPoolDemo
 * @description
 * @date 2021/6/8 13:31
 * @Version 1.0
 */

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable {
    int i;
    public MyTask(int i) {
        this.i = i;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ----> i:" + i);

    }
}
