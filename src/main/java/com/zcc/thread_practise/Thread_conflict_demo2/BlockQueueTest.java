package com.zcc.thread_practise.Thread_conflict_demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zcc
 * @ClassName BlockQueueTest
 * @description 当一个线程试图对一个已经满了的队列进行入队列操作时，它将会被阻塞，除非有另一个线程做了出队列操作；
 * 同样，当一个线程试图对一个空队列进行出队列操作时，它将会被阻塞，除非有另一个线程进行了入队列操作。
 * @date 2021/5/14 19:09
 * @Version 1.0
 */

public class BlockQueueTest {
    public static void main(String[] args) {
        //创建线程对象
        TicketRunnableLock ticketRunnable = new TicketRunnableLock();
        //第1个人
        Thread t1 = new Thread(ticketRunnable,"张三");
        //第2个人
        Thread t2 = new Thread(ticketRunnable,"李四");
        //第3个人
        Thread t3 = new Thread(ticketRunnable,"王五");
        //第4个人
        Thread t4 = new Thread(ticketRunnable,"赵六");

        try {
            //基于内存的阻塞队列
            BlockingQueue<Thread> queue = new LinkedBlockingQueue<Thread>();
            //加入队列，put(E e)将元素插入此队列的尾部，
            //如果该队列已满，则一直阻塞
            queue.put(t1);
            queue.put(t2);
            queue.put(t3);
            queue.put(t4);
            //执行队列
            while (!queue.isEmpty()) {
                //tack()获取并移除此队列头元素，若没有元素则一直阻塞
                Thread t = queue.take();
                System.out.println("当前从队列中取出来的线程为------>" + t.getName());
                t.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
