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
    //添加volatile关键字是为了防止指令重排，在第29行instance = new Singleton()
    private static volatile Singleton instance;
    //因为new Singleton() 实例化一个对象，将调用这个对象无参的构造方法（构造器），
    //将这个构造方法设置为私有的，将无法通过new实例化
    private Singleton(){}

    //提供一个静态的public对外访问，外部可以通过类名.方法名 通过返回值来获取唯一可用的对象
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    //此句需要执行3步的
                    //1.jvm开辟内存地址
                    //2.new Singleton() 创建Singleton对象
                    //3.将Singleton对象的引用地址，赋值给instance变量。(通常说把instance说成Singleton对象)
                    //如果出现指令重排，1 3 2 那么instance将赋值个空对象
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
