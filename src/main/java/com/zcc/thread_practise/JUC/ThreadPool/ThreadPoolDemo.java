package com.zcc.thread_practise.JUC.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zcc
 * @ClassName ThreadPoolDemo
 * @description 线程池要点：三大方法、7大参数、4种拒绝策略
 * 线程池好处：1.降低资源的消耗。2.提高响应的速度。3.方便管理；（线程服用、可以控制最大并发数、管理线程）
 * @date 2021/6/24 14:41
 * @Version 1.0
 */
//Executors 工具类、3大方法
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //单个线程
         ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 创建一个固定的线程池的大小
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //创建一个可伸缩的线程池，（遇强则强，遇弱则弱）
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 100; i++) {
                //使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "---> OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池使用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}
