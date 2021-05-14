package com.zcc.thread_practise.Thread_conflict_demo2;

/**
 * @author zcc
 * @ClassName TicketRunnable
 * @description
 * @date 2021/5/14 16:38
 * @Version 1.0
 */

public class TicketRunnable implements Runnable {

    //剩余的票数
    static int count = 10;
    //抢到第几张票
    static int num = 0;
    //是否售完票
    boolean flag = false;

    @Override
    public void run() {
        //票没有卖完的情况下，继续抢票
        while (!flag) {
            sale();
        }
    }

    //售票
    private synchronized void  sale() {
        if (count <= 0) {
            flag = true;
            return;
        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //剩余票数 减一
        count = count - 1;
        //抢到第几张票 加1
        num = num + 1;

        System.out.println(Thread.currentThread().getName() +" 抢到了第" + num + "张票，剩余：" + count +"张票。");
    }

}
