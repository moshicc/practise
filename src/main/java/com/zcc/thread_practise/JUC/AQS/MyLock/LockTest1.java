package com.zcc.thread_practise.JUC.AQS.MyLock;

public class LockTest1 {


    public static void main(String[] args) {
        UserStat userStat = new UserStat();
        for (int i = 0; i < 5; i++) {
            new Thread(userStat ,i+ "线程").start();
        }
    }

    LockTest1 test1 = new LockTest1();

    static class UserStat implements Runnable{
        SelfLock lock = new SelfLock();

        int count;
        public void getCount() {
            for (int i = 0; i < 100; i++) {
                count = count + 1;
                System.out.println(Thread.currentThread().getName() +"--->"+ count);

            }
        }

        @Override
        public void run() {
            lock.lock();
            getCount();
            lock.unlock();

        }
    }
}
