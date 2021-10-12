package com.zcc.thread_practise;

import java.util.concurrent.Semaphore;

/**
 * @author zcc
 * @ClassName ThinkingPeopleEat
 * @description 哲学家吃饭
 * @date 2021/10/12 19:48
 * @Version 1.0
 */

public class ThinkingPeopleEat {
    static final Semaphore count = new Semaphore(4);
    static final Semaphore[] mutex = {new Semaphore(1), new Semaphore(1),
            new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    static class Philosopher extends Thread {
        Philosopher(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            do {
                try {
                    count.acquire();
                    Integer i = Integer.parseInt(super.getName());
                    mutex[i].acquire();
                    mutex[(i + 1) % 5].acquire();
                    System.out.println("哲学家【{"+i+"}】号吃了通心粉！");

                    mutex[i].release();
                    mutex[(i + 1) % 5].release();
                    count.release();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("哲学家执行时产生异常！");
                }
            } while (true);
        }
    }

    public static void main(String[] args) {
        Philosopher p0 = new Philosopher("0");
        Philosopher p1 = new Philosopher("1");
        Philosopher p2 = new Philosopher("2");
        Philosopher p3 = new Philosopher("3");
        Philosopher p4 = new Philosopher("4");

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();

    }
}
