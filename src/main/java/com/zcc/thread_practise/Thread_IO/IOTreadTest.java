package com.zcc.thread_practise.Thread_IO;

/**
 * @author zcc
 * @ClassName IOTreadTest
 * @description
 * @date 2021/6/5 15:41
 * @Version 1.0
 */

public class IOTreadTest {
    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        Thread t1 = new Thread(copyFile, "线程1");
        t1.start();
    }
}
