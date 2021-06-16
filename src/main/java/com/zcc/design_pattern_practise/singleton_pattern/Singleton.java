package com.zcc.design_pattern_practise.singleton_pattern;

/**
 * @author zcc
 * @ClassName Singleton
 * @description  双检锁/双重校验锁
 * http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * https://www.runoob.com/design-pattern/singleton-pattern.html
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 * @date 2021/6/16 14:57
 * @Version 1.0
 */

public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
