package com.zcc.thread_practise.Thread_conflict_demo2.synch.A12B34;

/**
 * @author zcc
 * @ClassName PrintTest
 * @description
 * @date 2021/6/4 15:08
 * @Version 1.0
 */

public class PrintTest {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new PrintNumber(p);
        Thread t2 = new PrintWord(p);

        t1.start();
        t2.start();
    }
}
