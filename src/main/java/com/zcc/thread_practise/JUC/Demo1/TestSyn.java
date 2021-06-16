package com.zcc.thread_practise.JUC.Demo1;

/**
 * @author zcc
 * @ClassName TestSyn
 * @description
 * @date 2021/6/16 10:13
 * @Version 1.0
 */

public class TestSyn {
    public static void main(String[] args) {
        DataMethodSyn data = new DataMethodSyn();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
