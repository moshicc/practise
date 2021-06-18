package com.zcc.collection_practise.list_practise;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zcc
 * @ClassName ThreadListNoSafe
 * @description  并发情况下 List 不安全
 * @date 2021/6/18 17:21
 * @Version 1.0
 */

 class ThreadListNoSafe {
    public static void main(String[] args) {
        //并发情况下 List 不安全
        // List<String> arr = new ArrayList<>();
        //解决办法 1： 使用vetor  是线程安全的
        // List<String> arr = new Vector<>();
        //办法2：使用Collections工具类中的方法处理 synchronizedXXXX();
        //List<String> arr = Collections.synchronizedList(new ArrayList<>());
        //办法3：使用并发包current下面的CopyOnWriteArrayList() 类  参考：https://blog.csdn.net/hua631150873/article/details/51306021
        List<String> arr = new CopyOnWriteArrayList<>();



        for (int i = 0; i < 50; i++) {
            new Thread( ()->{
                    arr.add(UUID.randomUUID().toString().substring(0,5));

                System.out.println(Thread.currentThread().getName()+" ----> arr : " + arr);
            },String.valueOf(i)).start();
        }
    }



}
