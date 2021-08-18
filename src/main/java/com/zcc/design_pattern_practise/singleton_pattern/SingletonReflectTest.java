package com.zcc.design_pattern_practise.singleton_pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zcc
 * @ClassName SingletonReflectTest
 * @description 虽然这个对象通过单例模式创建的是单例的，但是使用反射还是可以破坏它的单例
 * @date 2021/6/28 13:54
 * @Version 1.0
 */

public class SingletonReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Singleton2 instance1 = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();

        //使用反射来破坏它的单例模式
        //获取Singleton2的构造方法
        Constructor<Singleton2> constructor = Singleton2.class.getDeclaredConstructor();
        //破坏它的private性，不然Singlton2的构造器被private修饰，是获取不到这个构造器的。
        constructor.setAccessible(true);
        //通过构造器创建这个对象的实例
        Singleton2 singleton2 = constructor.newInstance();

        System.out.println("instance1:" +instance1);
        System.out.println("instance2:" +instance2);
        System.out.println("singleton2:" +singleton2);


    }
}
