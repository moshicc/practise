package com.zcc.thread_practise.JUC.Demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcc
 * @ClassName VolatileTest
 * @description 线程之间的通信
 * 首先，要短信线程间通信的模型有两种：共享内存和消息传递
 *      题目：有两个线程A、B，A线程向一个集合里面依次添加元素"abc"字符串，一共添加十次，
 *          当添加到第五次的时候，希望B线程能够收到A线程的通知，然后B线程执行相关的业务操作。
 *  基于 volatile 关键字来实现线程间相互通信是使用共享内存的思想，大致意思就是多个线程同时监听一个变量，
 * 当这个变量发生变化的时候 ，线程能够感知并执行相应的业务。这也是最简单的一种实现方式
 * @date 2021/6/16 13:27
 * @Version 1.0
 */

public class VolatileTest {

    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //线程A
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("向线程A中添加元素，当前list容量：" + list.size());
                //1.判断是否达到条件，2.改变notice
                if (list.size() == 5)
                    notice = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }, "A");

        //线程B
        Thread threadB = new Thread(() -> {
            System.out.println("线程B启动了！");
            while (true) {
                if (notice) {
                    System.out.println("线程B 收到通知，开始做自己的事！");
                    break;
                }
            }
            //remove一个元素
//            list.remove("abc");
        }, "B");

        //先启动线程B
        threadB.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();

    }
}
