package com.zcc.thread_practise.Thread_conflict_demo2;

/**
 * @author zcc
 * @ClassName SpinLockTest
 * @description
 * @date 2021/5/28 17:02
 * @Version 1.0
 */

public class SpinLockTest {

    public static void main(String[] args) {
        //创建线程
        SpinLock lock = new SpinLock();
        TicketAtomicRunnable ticketRunnable = new TicketAtomicRunnable(lock);
        //第1个人
        Thread t1 = new Thread(ticketRunnable,"张三");
        //第2个人
        Thread t2 = new Thread(ticketRunnable,"李四");
        //第3个人
        Thread t3 = new Thread(ticketRunnable,"王五");
        //第4个人
        Thread t4 = new Thread(ticketRunnable,"赵六");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
