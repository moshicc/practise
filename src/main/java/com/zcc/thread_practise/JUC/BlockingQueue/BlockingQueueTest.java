package com.zcc.thread_practise.JUC.BlockingQueue;

import java.util.concurrent.*;

/**
 * 用阻塞队列实现生产者，消费者模型
 * 1.生产者生产，放入队列中，满了就阻塞，不满就放
 * 2.消费者消费队列中的元素，队列空了就休眠，有数据就取出
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue queue;
        //queue = new ArrayBlockingQueue<Integer>(10);
        //queue = new LinkedBlockingQueue();
        //queue = new LinkedBlockingDeque();
        queue = new PriorityBlockingQueue();
        //queue = new LinkedTransferQueue();
        //queue = new SynchronousQueue();
        //queue = new DelayQueue();


        //producer 生产者，开一百个线程，每个线程往队列中放入一个随机数
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
               queue.offer((int)(Math.random() * 10000));
            }).start();
        }


        //consumer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    Integer x = (Integer) queue.poll();
                    System.out.println("Receive : " + x +",currentThread :" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
