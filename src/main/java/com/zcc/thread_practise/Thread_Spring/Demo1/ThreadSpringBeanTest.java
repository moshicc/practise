package com.zcc.thread_practise.Thread_Spring.Demo1;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author zcc
 * @ClassName ThreadSpringBeanTest
 * @description 关于SpringBean默认为单例，高并发下如何保证并发安全。
 * 起因：因为spring只会创建一个controller对象，当这个controller里有个成员变量时，多个请求来临，则会进入到同一个单例的controller对象，
 * 并对变量的值进行修改，因此会互相的影响。（Spring bean的生命周期）
 * 如果非高并发下，一个请求进来后，对成员变量进行了修改，这个请求结束后，i的值会不会清空？
 * @date 2021/6/17 19:25
 * @Version 1.0
 */

public class ThreadSpringBeanTest {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = Controller.getInstrance();

        new Thread(()->{
            int a = controller.test1();
            System.out.println(Thread.currentThread().getName() + "--> i :" + a);
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            int a = controller.test1();
            System.out.println(Thread.currentThread().getName() + "--> i :" + a);
        }).start();


        Oth o1 = new Oth();
        Oth o2 = new Oth();

        new Thread(()->{
                o1.add();
                System.out.println(Thread.currentThread().getName() + "--> i :" + o1.i);
        },"AAA").start();
        new Thread(()->{
                o2.add();
                System.out.println(Thread.currentThread().getName() + "--> i :" + o2.i);

        },"BBB").start();

    }
}

class Oth{
    int i;
    public int  add() {
        return ++i;
    }
}
