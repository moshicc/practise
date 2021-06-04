package com.zcc.thread_practise.Thread_conflict_demo2.synch.A12B34;

/**
 * @author zcc
 * @ClassName PrintNumber
 * @description
 * @date 2021/6/4 14:49
 * @Version 1.0
 */

public class PrintNumber extends Thread{
    private Print p;

    public PrintNumber(Print p) {
        this.p = p;
    }
    public void run() {
        for (int i = 0; i < 26; i++) {
            //执行Print类中的打印数字方法
            p.printNumber();
        }
    }

}
