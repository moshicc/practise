package com.zcc.thread_practise.Thread_Spring.Demo1;

/**
 * @author zcc
 * @ClassName Controller
 * @description
 * @date 2021/6/17 19:22
 * @Version 1.0
 */

public class Controller {

    private int i;
    private static Controller Instrance;
    private Controller() {};
    public static Controller getInstrance() {
        if (Instrance == null) {
            Instrance = new Controller();
        }
        return Instrance;
    }

    public int test1() {
        return ++i;
    }

}
