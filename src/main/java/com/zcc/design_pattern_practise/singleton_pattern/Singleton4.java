package com.zcc.design_pattern_practise.singleton_pattern;

/**
 * 饿汉式 static final field
 * 缺点是它不是一种懒加载模式（lazy initialization），
 * 单例会在加载类后一开始就被初始化，即使客户端没有调用 getInstance()方法。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 Singleton 实例的创建是依赖参数或者配置文件的，
 * 在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 */
public class Singleton4 {
    //类加载时就初始化
    private static final Singleton4 instance = new Singleton4();
    private Singleton4(){};

    public static Singleton4 getInstance() {
        return instance;
    }
}
