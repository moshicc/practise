package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zcc
 * @ClassName CyclicBarrierDemo
 * @description 允许一组线程全部等待彼此达到共同屏障点的同步辅助。
 * @date 2021/6/21 19:45
 * @Version 1.0
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //当达到共同的屏障点（7）时，做“召唤神龙”。
        //未达到共同的屏障点（7）时，等待。
        //可以只传屏障点parties（7），不穿后面的动作barrierAction ，那么达到屏障点后，什么都不做，继续往下执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            //达到7时，执行
            System.out.println("召唤神龙成功！");
            System.out.println("等待的线程全都抵达到屏障点了，所以向下执行，才能执行到此句！");

        });

        for (int i= 0; i < 7; i++) {
            //因为lambda里面取不到i，所以要用个final转换下，好像在jdk 多少之后，不需要这个final转换了,就可以直接用了
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
