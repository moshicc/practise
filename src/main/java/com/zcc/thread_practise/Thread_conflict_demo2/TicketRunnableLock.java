package com.zcc.thread_practise.Thread_conflict_demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName TicketRunnableLock
 * @description https://blog.csdn.net/qq15577969/article/details/109706331?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-0&spm=1001.2101.3001.4242
 * @date 2021/5/14 17:32
 * @Version 1.0
 */

public class TicketRunnableLock implements Runnable{
    //剩余的票数
    static int count = 30;
    //抢到第几张票
    static int num = 0;
    //是否售完票
    boolean flag = false;
    //定义锁对象
    final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //票没有卖完的情况下，继续抢票
        while (!flag) {
            sale();
        }
    }

    //售票
    private  void  sale() {
        //枷锁
        lock.lock();
        try {
            //需要保证线程安全的代码放在try{}里
            if (count <= 0) {
                flag = true;
                return;
            }
            //剩余票数 减一
            count = count - 1;
            //抢到第几张票 加1
            num = num + 1;
            System.out.println(Thread.currentThread().getName() +" 抢到了第" + num + "张票，剩余：" + count +"张票。");
        } finally {
            System.out.println(Thread.currentThread().getName()+"抢票结束---> 释放锁");
            //释放锁（放在finally里，保证不论try里代码出现什么异常，最后都能释放锁，防止lock得不到释放，造成死锁）
            lock.unlock();
        }
 }

}