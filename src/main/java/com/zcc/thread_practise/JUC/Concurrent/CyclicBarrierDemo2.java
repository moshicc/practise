package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.*;

/**
 * @author zcc
 * @ClassName CyclicBarrierDemo2
 * @description
 * @date 2021/10/11 17:34
 * @Version 1.0
 */

public class CyclicBarrierDemo2 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
            System.out.println("----> 5个线程全部抵达内存屏障后，需要做的事");
            System.out.println("说一句：Hello World！");
        });

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                20,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        CyclicBarrierDemo2 demo = new CyclicBarrierDemo2();
        threadPool.execute(()->{

            try {
                int i = demo.queryManCount();
                //查询结束后等待
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(()->{

            try {
                int i = demo.queryWomanCount();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//                try {
//                    //执行自己的业务逻辑
//                    System.out.println(Thread.currentThread().getName() + "-->正在执行自己的业务");
//                    //暂停2秒，模拟执行业务
//                    Thread.sleep(2000);
//
//                    //执行完业务后,等待其他5条线程都执行好
//                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
    }

    //查询男人数量
    private int queryManCount() throws InterruptedException {
        //业务
        System.out.println(Thread.currentThread().getName() + "---> 查询男人数量");
        Thread.sleep(3000);
        return 300;
    }
    //查询女人数量
    private int queryWomanCount() throws InterruptedException {
        //业务
        System.out.println(Thread.currentThread().getName() + "->查询女人的数量");
        Thread.sleep(8000);
        return 200;
    }


}
