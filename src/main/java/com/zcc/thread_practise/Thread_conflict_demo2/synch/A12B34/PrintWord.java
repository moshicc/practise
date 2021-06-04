package com.zcc.thread_practise.Thread_conflict_demo2.synch.A12B34;

/**
 * @author zcc
 * @ClassName PrintWord
 * @description 打印字母线程
 * @date 2021/6/4 15:04
 * @Version 1.0
 */

public class PrintWord  extends Thread{
    private Print p;

    public PrintWord(Print p) {
        this.p = p;
    }
    public void run() {
        for (int i =0; i < 26; i++) {
            p.printWord();
        }
    }

}
