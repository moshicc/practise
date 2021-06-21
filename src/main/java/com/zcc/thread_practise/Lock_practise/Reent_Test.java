package com.zcc.thread_practise.Lock_practise;

/**
 * @author zcc
 * @ClassName Reent_Test
 * @description
 * @date 2021/6/5 14:48
 * @Version 1.0
 */

public class Reent_Test {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan("超人A");
        Reent_Thread rt = new Reent_Thread(superMan);
        Thread t1 = new Thread(rt, superMan.getName());
        t1.start();
    }
}
