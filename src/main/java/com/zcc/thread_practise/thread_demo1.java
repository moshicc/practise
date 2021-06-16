package com.zcc.thread_practise;


import com.zcc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.logging.Logger;

/**
 * @author zcc
 * @ClassName Thread_demo1
 * @description 继承Thread类，重写run方法
 * @date 2021/5/12 15:52
 * @Version 1.0
 */
class Thread_demo1 {

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                System.out.println("threadAAAA ---------->" + i);
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                System.out.println("threadBBBB ----->" + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();

    }

}

