package com.zcc.thread_practise.Thread_example1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zcc
 * @ClassName MyThread
 * @description
 * 数据库里有一个电话本，里面有1000条数据，现在有10个人，轮流去数据库里取查自己的电话号码，
 * 求出这10个人查出自己的电话号码总用时。
 * @date 2021/5/28 18:30
 * @Version 1.0
 */

public class MyThread implements Runnable {

    public ArrayList<PhoneBook> list;
    public String name;

    public MyThread(ArrayList<PhoneBook> list, String name) {
        this.list = list;
        this.name = name;
    }


    public void run() {
        doSomething(name, list);
    }

    public void doSomething( String name,ArrayList array) {
        Iterator iterator = array.iterator();
        int num = 1;
        while (iterator.hasNext()) {
            PhoneBook temp = (PhoneBook) iterator.next();
            if (temp.getName().equals(name)) {
                System.out.println("姓名："+temp.getName()+",电话："+ temp.getPhone() +",地址：" + temp.getAddress() );
                return;
            }
        }
    }
}
