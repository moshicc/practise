package com.zcc.thread_practise.Thread_HashMap_Error;

import java.util.HashMap;

/**
 * @author zcc
 * @ClassName ThreadHashMapError
 * @description
 * @date 2021/5/31 14:11
 * @Version 1.0
 */

public class ThreadHashMapError {
    public static final HashMap<String, String> firstHashMap = new HashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 250; i++) {
                    firstHashMap.put(String.valueOf(i), String.valueOf(i));
                    System.out.println("t1 插入了 "+i+"----> " + firstHashMap.get(i));
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int j = 250; j < 500; j++) {
                    firstHashMap.put(String.valueOf(j), String.valueOf(j));
                    System.out.println("t2 插入了 "+j+"----> " + firstHashMap.get(j));

                }
            }
        };
        t1.start();
        t2.start();

        Thread.currentThread().sleep(1000);
        for (int l = 0; l < 500; l++) {
            if (!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))) {
                System.out.println(String.valueOf(l) + ":" +firstHashMap.get(String.valueOf(l)));
            };
        }
    }
}
