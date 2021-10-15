package com.zcc.reflect_practise;

import java.lang.reflect.Field;

/**
 * @author zcc
 * @ClassName Reflect_demo3
 * @description  java 反射机制：获取类对象
 *   三种方式中：
 *   第1种需要导入类的包，依赖太强，不导包就抛编译错误。
 *   第3种对象都有了还要反射干什么。
 *   一般都第2种，一个字符串可以传入也可写在配置文件中等多种方法。
 * @date 2021/10/15 14:00
 * @Version 1.0
 */

public class Reflect_demo3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("-----1.----直接：类.class 获取-------------");
     Class c = Person.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
      System.out.println("-----2.---Class.forName() 加类的全路径名获取(常用)--------------");
        Class<?> aClass = Class.forName("com.zcc.reflect_practise.Person");
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("-------3.------对象.getClass()获得这个对象对应的类对象---------------------");
        Class<? extends Person> aClass1 = new Person().getClass();
        Field[] fields2 = aClass1.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getName());
        }

    }
}
