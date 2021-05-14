package com.zcc.thread_practise.Thread_conflict_demo;

/**
 * @author zcc
 * @ClassName AccountManage
 * @description
 * @date 2021/5/14 13:54
 * @Version 1.0
 */

//取款线程类
public class AccountManage implements Runnable {

    private Account account; //需要被取款的账户
    private double money; //需要取走金额

    public AccountManage(Account account, double money) {
        super();
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        drawCash();
    }

    // 取钱的方法
    public synchronized void drawCash(){
        //判断账户中的余额是否足够
        if (account.getCash() >= money) {
            System.out.println("当前取得线程的是：" + Thread.currentThread() + "当前的钱为："+account.getCash());
            try {
                //睡眠1毫秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //减少账户的余额
            account.setCash(account.getCash() - money);
            System.out.println("当前线程：" + Thread.currentThread() + " 取款成功，余额：" + account.getCash());
        } else {
            System.out.println("当前线程：" + Thread.currentThread() + "取款失败，余额不足！");
        }
    }

    // 取钱的方法 （没有用synchronized 修饰 ，会导致第一个线程进入到if判断后，第二的线程也进到if判断，都会执行accout.getCash -money 导致 取了两次1000元）
//    public  void drawCash(){
//        //判断账户中的余额是否足够
//        if (account.getCash() >= money) {
//            System.out.println("当前取得线程的是：" + Thread.currentThread() + "当前的钱为："+account.getCash());
//            try {
//                //睡眠1毫秒
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //减少账户的余额
//            account.setCash(account.getCash() - money);
//            System.out.println("当前线程：" + Thread.currentThread() + " 取款成功，余额：" + account.getCash());
//        } else {
//            System.out.println("当前线程：" + Thread.currentThread() + "取款失败，余额不足！");
//        }
//    }
}
