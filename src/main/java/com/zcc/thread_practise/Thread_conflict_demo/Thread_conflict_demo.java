package com.zcc.thread_practise.Thread_conflict_demo;

/**
 * @author zcc
 * @ClassName Thread_conflict_demo
 * @description
 * @date 2021/5/14 13:25
 * @Version 1.0
 */

public class Thread_conflict_demo {
    public static void main(String[] args) {

        //创建账户类，余额10000
        Account a = new Account("10001", 1000);
        //创建Runnable 对象，每次取款10000元
        AccountManage am = new AccountManage(a, 1000);

        Thread t1 = new Thread(am);
        Thread t2 = new Thread(am);
        //启动两个线程
        t1.start();
        t2.start();
    }
}


