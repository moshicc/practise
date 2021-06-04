package com.zcc.thread_practise.Thread_conflict_demo2.synch.A12B34;

/**
 * @author zcc
 * @ClassName Print
 * @description
 * @date 2021/6/4 14:51
 * @Version 1.0
 */

public class Print {
    private int i = 1;
    private char j = 'A';

    public Print() {

    }

    public synchronized void printNumber() {//同步方法
        System.out.print(String.valueOf(i) + String.valueOf(i + 1));
        i = i + 2;
        notifyAll();
        try {
            wait();//先唤醒其他进程，再阻塞本进程，如果顺序颠倒了，进程阻塞后不能再唤醒其他进程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printWord() {
        System.out.print(j);
        j++;
        notifyAll();
        try {
            if ( j <= 'Z') {//Z之后就不再等待了
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
