package com.zcc.thread_practise.Lock_practise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zcc
 * @ClassName Reent_Thread
 * @description
 * @date 2021/6/5 14:24
 * @Version 1.0
 */

public class Reent_Thread implements Runnable{

    private static int totalEnergy = 100;
    private SuperMan man;
    private static volatile boolean flag = true;


   Lock lock = new ReentrantLock();

   public Reent_Thread(SuperMan man) {
       this.man = man;
   }

    @Override
    public void run() {
        if (totalEnergy <= 0) {
            System.out.println("SuperMan:---->总能能量消耗完了！");
        } else {
            chargeEnergy();
        }
    }

    public void chargeEnergy() {
       lock.lock();
       Thread t = Thread.currentThread();
       try {
           while (flag) {
               if (totalEnergy <= 0) {
                   System.out.println("SuperMan:" +t.getName() + "---->总能能量消耗完了！");
                   flag = false;
                   continue;
               }
               man.setEnergy(man.getEnergy() + 1);
               System.out.println("SuperMan:" + man.getName() +"正在充能，当前能量为----->" + man.getEnergy() );
               totalEnergy --;
           }
       } catch (Exception e) {
            e.printStackTrace();
       } finally {
           lock.unlock();
       }

    }
}
