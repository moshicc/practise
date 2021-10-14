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

public class ThreadPoolDemo4 {
    static Map<String, Object> peopleMap = new HashMap<>();
    static Map<String, Object> ckMap = new HashMap<>();


    public static void main(String[] args) {
        ThreadPoolDemo4 demo4 = new ThreadPoolDemo4();
        String sqid = "10002";

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
            demo4.copyPeopleInfo(sqid);
        });

        threadPoolExecutor.execute(()->{
            demo4.copyCkxx(sqid);
        });

        System.out.println("复制受理表完成，结束！");
        System.out.println("活跃核心数：" + threadPoolExecutor.getActiveCount());
        threadPoolExecutor.shutdown();
        System.out.println("关闭线程池");

    }

    //复制人员信息
    private void copyPeopleInfo(String sqid) {

        People p = (People)peopleMap.get(sqid);
        People p2 = new People();

        p2.setName(p.getName());
        p2.setAge(p.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //复制完成
        System.out.println("当前线程："+Thread.currentThread().getName()+"复制人员信息完成：" + p2.toString());

    }
    //复制仓库信息
    private void copyCkxx(String sqid) {
        Ck ck = (Ck)ckMap.get(sqid);
        Ck ck2 = new Ck();

        ck2.setName(ck.getName());
        ck2.setAddress(ck.getAddress());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

class People{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("People{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

class Ck{
    private String name;
    private String address;

    public Ck() {
    }

    public Ck(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ck{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}