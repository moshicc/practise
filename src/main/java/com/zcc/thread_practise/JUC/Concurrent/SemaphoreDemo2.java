package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.*;

/**
 * @author zcc
 * @ClassName SemaphoreDemo2
 * @description
 * @date 2021/10/11 16:36
 * @Version 1.0
 */

public class SemaphoreDemo2 {
    public static void main(String[] args) {
        //控制最大并发线程数量
        Semaphore semaphore = new Semaphore(3);
        //创建线程池
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
//                4,
//                20,
//                20,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    try {
                        //得到许可
                        semaphore.acquire();
                        //业务代码
                        System.out.println(Thread.currentThread().getName() + "--->得到许可");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "--->业务处理完成，释放许可");

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //释放许可
                        semaphore.release();
                    }
                });

//            new Thread(()->{
//                try {
//                    //得到许可
//                    semaphore.acquire();
//                    //业务代码
//                    System.out.println(Thread.currentThread().getName() + "--->得到许可");
//                    Thread.sleep(10);
//                    System.out.println(Thread.currentThread().getName() + "--->业务处理完成，释放许可");
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    //释放许可
//                    semaphore.release();
//                }
//
//            },String.valueOf(i)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
