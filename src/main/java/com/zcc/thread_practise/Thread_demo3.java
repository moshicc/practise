package com.zcc.thread_practise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zcc
 * @ClassName Thread_demo3
 * @description 使用Callable和Future创建线程
 * @date 2021/5/12 19:41
 * @Version 1.0
 */

public class Thread_demo3 implements Callable {
    @Override
    public Object call() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        long sum = System.currentTimeMillis() -startTime;
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread_demo3 demo3 = new Thread_demo3();
        FutureTask task = new FutureTask(demo3);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println(task.get());
    }
}
