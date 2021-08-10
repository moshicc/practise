package com.zcc.thread_practise.JUC.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**https://www.cnblogs.com/tjudzj/p/4454490.html
 * blockingqueue 阻塞队列
 * 在多线程并发处理，线程池的时候 一般使用。数据由队列的一端输入，从另外一端输出
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒（
 * 生产者消费者问题：生产者放入线程，消费者取出线程，由于两者速度不同造成的问题可以解决）
 * 学习他的添加 移除。 共4组API
 * 1.抛出异常：add 、remove element
 * 2.有返回值，不抛出异常：offer、poll、peek
 * 3.阻塞等待：put、take
 * 4.超时等待：offer、poll
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test1() {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //再添加一个 、抛出异常
        //System.out.println(blockingQueue.add("f"));

        System.out.println("---------------------");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //再移除一个，抛出异常
       // System.out.println(blockingQueue.remove());
    }

    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //再添加一个 、一直等待 阻塞
        //blockingQueue.put("g");

        System.out.println("---------------------");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //再移除一个， 因为没有元素，所以一直等待
         System.out.println(blockingQueue.take());
    }

    public static void test2() {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //再添加一个 、返回值  false
        //System.out.println(blockingQueue.add("f"));

        System.out.println("---------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //再移除一个， 返回值为null
        System.out.println(blockingQueue.poll());
    }

    public static void test4() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //再添加一个 、超过2秒后 退出
        //blockingQueue.offer("aa",5, TimeUnit.SECONDS);

        System.out.println("---------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //再移除一个，抛出异常
        //blockingQueue.poll(5,TimeUnit.SECONDS);
    }
}
