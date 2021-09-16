package com.zcc.thread_practise.Thread_Demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName TestDealData
 * @description
 * @date 2021/9/16 16:27
 * @Version 1.0
 */

public class TestDealData {
    public static void main(String[] args) throws InterruptedException {
          ReentrantLock lock = new ReentrantLock();
        int n = 5;
        DealDataThread dealDataThread = new DealDataThread();
        //创建3个线程
        for (int i = 0; i < 3; i++) {
            new Thread(()->{

                dealDataThread.print(n);

            }).start();
            //new Thread(dealDataThread).start();
        }
//        Thread thread1 = new Thread(dealDataThread);
//        Thread thread2 = new Thread(dealDataThread);
//        thread1.start();
//        thread2.join();
//        thread2.start();
    }
}
