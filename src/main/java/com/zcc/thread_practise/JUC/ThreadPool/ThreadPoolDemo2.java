package com.zcc.thread_practise.JUC.ThreadPool;

import java.util.concurrent.*;

/**
 * @author zcc
 * @ClassName ThreadPoolDemo2
 * @description 使用ThreadPoolExecutor方式创建线程池，设置7大参数
 * @date 2021/6/24 14:58
 * @Version 1.0
 */
/**
 * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异
 常
 * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！ 比如下面的代码，多余的线程，会让从main线程来的，会让main线程执行。
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
 */


public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, //核心线程数
                5, //最大线程数
                5,  //线程空闲时存活时间
                TimeUnit.SECONDS,  //时间单位
                new LinkedBlockingQueue<>(3),  //阻塞队列
                Executors.defaultThreadFactory(),  //线程工厂，创建线程的，一般不用动
                new ThreadPoolExecutor.AbortPolicy() //拒绝策略
        );

        try {
            // 最大承载量 ： 最大线程数 + 阻塞队列容量
            // 再超过这个最大承载量就执行 拒绝策略
            for (int i = 0; i < 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "--> OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，记得关闭
            threadPool.shutdown();
        }
    }
}
