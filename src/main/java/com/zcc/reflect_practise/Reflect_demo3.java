package com.zcc.reflect_practise;

import java.lang.reflect.Field;

/**
 * @author zcc
 * @ClassName Reflect_demo3
 * @description
 * @date 2021/10/15 14:00
 * @Version 1.0
 */

public class Reflect_demo3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("---------直接：类.class 获取-------------");
     Class c = Person.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
      System.out.println("--------Class.forName() 加类的全路径名获取(常用)--------------");
        Class<?> aClass = Class.forName("com.zcc.reflect_practise.Person");
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("-------------对象.getClass()获得这个对象对应的类对象---------------------");
        Class<? extends Person> aClass1 = new Person().getClass();
        Field[] fields2 = aClass1.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getName());
        }

    }
}
