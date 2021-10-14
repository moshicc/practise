package com.zcc.thread_practise.JUC.ThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author zcc
 * @ClassName ThreadPoolDemo4
 * @description
 * @date 2021/10/14 10:31
 * @Version 1.0
 */

public class ThreadPoolDemo5 {
    static Map<String, Object> peopleMap = new HashMap<>();
    static Map<String, Object> ckMap = new HashMap<>();


    public static void main(String[] args) {
        ThreadPoolDemo5 demo5 = new ThreadPoolDemo5();
        String sqid = "10002";

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        threadPoolExecutor.execute(()->{
            demo5.copyPeopleInfo(sqid);
        });

        threadPoolExecutor.execute(()->{
            demo5.copyCkxx(sqid);
        });

        System.out.println("复制受理表完成，结束！");

    }



    //复制人员信息
    private void copyPeopleInfo(String sqid) {

        People p = (People)peopleMap.get(sqid);
        People p2 = new People();

        p2.setName(p.getName());
        p2.setAge(p.getAge());
        //复制完成
        System.out.println("当前线程："+Thread.currentThread().getName()+"复制人员信息完成：" + p2.toString());

    }
    //复制仓库信息
    private void copyCkxx(String sqid) {
        Ck ck = (Ck)ckMap.get(sqid);
        Ck ck2 = new Ck();

        ck2.setName(ck.getName());
        ck2.setAddress(ck.getAddress());
        //复制完成
        System.out.println("当前线程："+Thread.currentThread().getName()+"复制仓库信息完成：" +ck.toString());
    }

    static {
        //初始化数据
        People p1 = new People("张三", 18);
        People p2 = new People("李四", 28);
        People p3 = new People("王五", 19);

        Ck ck1 = new Ck("仓库1号","浦东寿光路大道1号");
        Ck ck2 = new Ck("仓库2号","黄浦区普泰小七");
        Ck ck3 = new Ck("仓库3号","长宁区新桥机场2号");

        peopleMap.put("10001", p1);
        peopleMap.put("10002", p2);
        peopleMap.put("10003", p3);

        ckMap.put("10001", ck1);
        ckMap.put("10002", ck2);
        ckMap.put("10003", ck3);

    }

}

