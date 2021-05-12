package com.zcc.thread_practise;

/**
 * @author zcc
 * @ClassName Thread_demo2
 * @description 创建一个类，实现Runnable接口。
 * @date 2021/5/12 15:55
 * @Version 1.0
 */

public class Thread_demo2 implements Runnable {
    @Override
    public void run() {
        //编写自己的线程需要执行的代码
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"--------->" + i);
        }
    }

    public static void main(String[] args) {
        Thread_demo2 thread_demo2 = new Thread_demo2();

        Thread t1 = new Thread(thread_demo2);
        Thread t2 = new Thread(thread_demo2);

        t1.start();
        t2.start();

    }
}
