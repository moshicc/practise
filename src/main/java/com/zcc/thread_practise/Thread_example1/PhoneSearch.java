package com.zcc.thread_practise.Thread_example1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author zcc
 * @ClassName PhoneSearch
 * @description
 * @date 2021/5/28 18:32
 * @Version 1.0
 */

public class PhoneSearch {
    public static void main(String[] args) {
        ArrayList<PhoneBook> array = new ArrayList<>();
        //初始化人员
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.initPhoneBook(array);
        PhoneSearch phoneSearch = new PhoneSearch();
        // phoneSearch.test1(array);
        long start = System.currentTimeMillis();
        for (int a = 0; a < 1000; a ++) {
            MyThread my = new MyThread(array, "同学"+a);
            Thread thread = new Thread(my);
            thread.start();
        }

        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("耗时 ---------> " + total + "ms");


    }

    public void searchPhoneBook(String name, ArrayList<PhoneBook> array) {
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

    public void test1(ArrayList array) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.size(); i++ ) {
            searchPhoneBook("同学" + i, array);
        }
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("耗时 ---------> " + total + "ms");
    }
}
