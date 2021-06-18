package com.zcc.thread_practise.JUC.Demo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zcc
 * @ClassName WNSTest2
 * @description 廖雪峰 wait和notify例子
 *  一个线程一直往队列中添加任务
 *  另一个线程一直从队列中取出任务（当队列中有任务是时才取出，没有任务时等待）
 * @date 2021/6/16 14:11
 * @Version 1.0
 */

public class WNSTest2 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue queue = new TaskQueue();
        List<Thread> list = new ArrayList<Thread>();
        //开5个线程从队列中取任务，执行任务
        for (int i = 0; i < 5; i++) {
            Thread getThread = new Thread(()->{
                //执行task
                while(true) {
                    try {
                        String t = queue.getTask();
                        System.out.println("从队列中取得的任务为：" + t + " ----> execute task");
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            },"A" + i);
            getThread.start();
            list.add(getThread);
        }
        //往队列中添加任务
        Thread addThread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //放task
                String s = "t-" + Math.random();
                System.out.println("add task :" + s);
                queue.addTask(s);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        addThread.start();
        addThread.join();
        Thread.sleep(100);
        for (Thread t : list) {
            t.interrupt();
        }


    }

}

/* *
 * @description:
 * 在Java程序中，synchronized解决了多线程竞争的问题。
 *
 * wait、notify和notifyAll都会释放锁，但是虽然都是释放锁，他们之间会有所不同，
 * 我们的 wait 方法执行后会立即释放锁，等待被唤醒的时候会重新持有锁。
而notify和notifyAll也会释放锁，但是不是立即释放锁，执行完notify/notifyAll方法后会立即通知其它正在等待的线程，
* 但不是立即释放锁，而是会等到其synchronized内中的代码全部执行完之后，才会释放锁。所以我们一般都时在我们synchronized内的最后才会调用 notify/notifyAll。
 * @author zcc13
 * @date 2021/6/16 14:13
 */
class TaskQueue{
    Queue<String> queue = new LinkedList<>();

    //对于一个任务管理器，多个线程同时往队列中添加任务
    public synchronized void addTask(String s) {
        this.queue.add(s);
        //添加一个任务之后，通知其他（因为队列里任务为空导致等待）线程唤醒。
        this.notifyAll();
    }

    //再编写一个getTask()方法取出队列的第一个任务
    public synchronized String getTask() throws InterruptedException {
        //如果队列为空，则一直循环等待，使用wait等待，释放锁
        while (queue.isEmpty()) {
            //如果对象调用了wait方法就会使持有该对象的线程把该对象的控制权交出去，然后处于等待状态。
            this.wait();
        }
        String task = queue.remove();
        System.out.println("移除这个任务：" +task);
        return task;
    }
}
