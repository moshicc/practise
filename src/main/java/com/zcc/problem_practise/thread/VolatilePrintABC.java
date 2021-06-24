package com.zcc.problem_practise.thread;

/**
 * @author zcc
 * @ClassName VolatilePrintABC
 * @description
 * @date 2021/6/24 18:16
 * @Version 1.0
 */

public class VolatilePrintABC extends Thread {
    private volatile static int state = 0;
    private static String name = "ABC";
    private int type;

    VolatilePrintABC(int type) {
        this.type = type;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10 ;) {
            if (state % 3 == type) {
                System.out.print(name.charAt(type));
                state ++;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new VolatilePrintABC(0).start();
        new VolatilePrintABC(1).start();
        new VolatilePrintABC(2).start();

    }

}
