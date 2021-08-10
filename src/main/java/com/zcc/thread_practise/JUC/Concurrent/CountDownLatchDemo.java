package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName CountDownLatchDemo
 * @description 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 *
 * 1.提供了一个构造方法，参数count为计数值；
 *
 * 2. 三个常用方法：
 *      // 1. 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
 *       public void await() throws InterruptedException { };
 *      //2. 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
 *      public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
 *      //3. 将count值减1
 *      public void countDown() { };
 * @date 2021/6/21 19:23
 * @Version 1.0
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数为3条线程
        CountDownLatch startSignle = new CountDownLatch(3);

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ "---> Go out" );
                startSignle.countDown();//数量 -1
            },String.valueOf(i)).start();
        }

//        long state = startSignle.getCount();
//        System.out.println("state:" + state);

        startSignle.await();//等待计数器归0，然后再想下执行。（如果上面调用countDown的个数不能使3减到0，那么将一直在此等待）

        System.out.println("Close Door");
    }
}
