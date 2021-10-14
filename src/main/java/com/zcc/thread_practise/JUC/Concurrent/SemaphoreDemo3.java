package com.zcc.thread_practise.JUC.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zcc
 * @ClassName SemaphoreDemo3
 * @description
 * @date 2021/10/14 19:40
 * @Version 1.0
 */

public class SemaphoreDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        ExecutorService service = Executors.newFixedThreadPool(3);
        Integer count = 10;
        service.submit(new Worker("A",s1,s2,count));
        service.submit(new Worker("B",s2,s3,count));
        service.submit(new Worker("C",s3,s1,count));

        Thread.sleep(1000);
        service.shutdown();



    }

    public static class Worker implements Runnable{


        private String key;
        private Semaphore curr;
        private Semaphore next;
        private Integer count;

        public Worker(String key, Semaphore curr, Semaphore next, Integer count) {
            this.key = key;
            this.curr = curr;
            this.next = next;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {

                    //获取当前锁
                    try {
                        curr.acquire();  //curr - 1
                        System.out.print(key+"" + i);
                        //释放下个锁
                        next.release(); //next + 1
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}
