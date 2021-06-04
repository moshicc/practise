package com.zcc.thread_practise.Thread_conflict_demo2.synch;

/**
 * @author zcc
 * @ClassName Test
 * @description
 * @date 2021/6/3 19:16
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "线程AAA");
        Thread t2 = new Thread(myThread, "线程BBB");

        t1.start();
        t2.start();
    }
}
