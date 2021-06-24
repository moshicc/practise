package com.zcc.problem_practise.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName CountDownLatchPrintABC
 * @description 多线程 循序打印ABC 打印10轮 （ABC分别是线程的名字，同时启动），如ABCABCABCABC
 * 初始(A=1,B=0,C=0)—>第一次执行线程A时(A=1,B=0,C=0)—->第一次执行线程B时（A=0,B=1,C=0）—->第一次执行线程C时(A=0,B=0,C=1)—>第二次执行线程A(A=1,B=0,C=0)如此循环。
 * @date 2021/6/24 16:53
 * @Version 1.0
 */

public class CountDownLatchPrintABC {

    //设置信号量
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore semaphoreA = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);


    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreA.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.print(Thread.currentThread().getName());
                    semaphoreB.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                }
                //countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreB.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreC.release();
                }
                //countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

        new Thread(() ->{
            try {
                for (int i = 0; i < 10; i++) {
                    semaphoreC.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreA.release();
                }
                //countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"C").start();

        //countDownLatch.await();
        System.out.println();
        System.out.println("执行结束--------");
    }


    //打印A方法
    public static void printA() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreA.acquire();
            System.out.print(Thread.currentThread().getName());
            semaphoreB.release();
        }
    }
    //打印B方法
    public static void printB() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreB.acquire();
            System.out.print(Thread.currentThread().getName());
            semaphoreC.release();
        }
    }
    //打印C方法
    public static void printC() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            semaphoreC.acquire();
            System.out.print(Thread.currentThread().getName());
            semaphoreA.release();
        }
    }
}
