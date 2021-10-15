package com.zcc.reflect_practise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zcc
 * @ClassName Reflect_demo4
 * @description
 * @date 2021/10/15 15:02
 * @Version 1.0
 */

public class Reflect_demo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //step1. 获取类对象
        Class<?> aClass = Class.forName("com.zcc.reflect_practise.Person");
        //step2. 用类对象获取类的构造方法
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        //step3. 用类的构造方法获取对象
        Object o = constructor.newInstance();

        if (o instanceof com.zcc.reflect_practise.Person) {
            Person p = (Person) o;
            p.setName("zcc");
            p.setAge(20);
            p.setGerden("男");
            System.out.println(p.toString());
        }

        System.out.println(o.getClass().getName());
        System.out.println(o.getClass());

    }
}
