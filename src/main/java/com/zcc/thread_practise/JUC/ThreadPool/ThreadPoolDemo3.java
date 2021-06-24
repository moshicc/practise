package com.zcc.thread_practise.JUC.ThreadPool;

import java.util.concurrent.*;

/**
 * @author zcc
 * @ClassName ThreadPoolDemo3
 * @description
 * 池的最大的大小如何去设置！
 * 了解：IO密集型，CPU密集型：（调优）
 * @date 2021/6/24 16:26
 * @Version 1.0
 */
// 自定义线程池！工作 ThreadPoolExecutor
// 最大线程到底该如何定义
// 1、CPU 密集型，几核，就是几，可以保持CPu的效率最高！
// 2、IO 密集型 > 判断你程序中十分耗IO的  一般是它的2倍，这样IO全执行还有剩余的线程执行其他的。
public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        int localMaxCoreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                localMaxCoreSize,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
