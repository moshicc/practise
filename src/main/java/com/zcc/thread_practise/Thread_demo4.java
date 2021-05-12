package com.zcc.thread_practise;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zcc
 * @ClassName Thread_demo4
 * @description 通过线程池来创建线程
 * @date 2021/5/12 19:48
 * @Version 1.0
 */

public class Thread_demo4 implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName() + "------>  i的值为：" + i);
        }
    }

    public static void main(String[] args) {
        //创建一个具有固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //向线程池中放入3个线程
        pool.submit(new Thread_demo4());
        pool.submit(new Thread_demo4());
        pool.submit(new Thread_demo4());

        //关闭线程池
        pool.shutdown();
    }
}
