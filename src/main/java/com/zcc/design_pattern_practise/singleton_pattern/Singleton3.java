package com.zcc.design_pattern_practise.singleton_pattern;

/**
 * @author zcc
 * @ClassName Singleton3
 * @description 懒汉模式 线程安全，但是效率低因为加了synchronized
 * 最简单的方法是将整个 getInstance() 方法设为同步（synchronized）。
 * @date 2021/6/16 19:57
 * @Version 1.0
 */

public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){};

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}
