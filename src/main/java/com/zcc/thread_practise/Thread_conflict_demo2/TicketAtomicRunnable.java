package com.zcc.thread_practise.Thread_conflict_demo2;

/**
 * @author zcc
 * @ClassName TicketRunnable
 * @description
 * @date 2021/5/14 16:38
 * @Version 1.0
 */

public class TicketAtomicRunnable implements Runnable {

    //剩余的票数
    static int count = 30;
    //抢到第几张票
    static int num = 0;
    //是否售完票
    boolean flag = false;
    //自旋锁
    private SpinLock spinLock;

    //构造函数
    public TicketAtomicRunnable() {

    }

    public TicketAtomicRunnable(SpinLock lock) {
        this.spinLock = lock;
    }

    @Override
    public void run() {
        //票没有卖完的情况下，继续抢票
        while (!flag) {
            sale();
        }
    }

    //售票
    private synchronized void  sale() {
        try {
            //上锁
            spinLock.lock();
            Thread.sleep(10);

            if (count <= 0) {
                flag = true;
                return;
            }
            //剩余票数 减一
            count = count - 1;
            //抢到第几张票 加1
            num = num + 1;
            System.out.println(Thread.currentThread().getName() +" 抢到了第" + num + "张票，剩余：" + count +"张票。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //无论如何，当前线程都要释放锁，把线程位置释放出来，让他们继续竞争
            spinLock.unlock();
        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

}
