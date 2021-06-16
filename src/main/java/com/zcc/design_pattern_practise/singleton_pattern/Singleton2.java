package com.zcc.design_pattern_practise.singleton_pattern;

/**
 * @author zcc
 * @ClassName Singleton2
 * @description  懒汉式  线程不安全
 * 使用了懒加载模式，但是却存在致命的问题。
 * 当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。
 * 也就是说在多线程下不能正常工作。
 * @date 2021/6/16 19:30
 * @Version 1.0
 */

public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){};

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
