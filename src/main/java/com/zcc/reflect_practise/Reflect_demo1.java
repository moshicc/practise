package com.zcc.reflect_practise;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc
 * @ClassName Reflect_demo1
 * @description
 * @date 2021/5/18 16:28
 * @Version 1.0
 */

public class Reflect_demo1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        person.setAge(22);
        person.setGerden("男");
        Map<String, Object> map =getDataToMap(person);
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        } );
//        getData3(person);
//        getData1("com.zcc.reflect_practise.Person");
//        getData2();
//        breakData("com.zcc.reflect_practise.Person","name","11");
    }
    /* *
     * @description:  反射机制获取类有三种方法
     *  1.     Class c = Class.forName();
     *  2.     Class c = 类名.class
     *  3.     类  e = new 类();
     *          Class c = e.getClass()
     *
     * 获取类以后，可以创建类的对象  Object o = c.newInstance();
     * @param obj
     * @return
     * @throws
     * @author zcc13
     * @date 2021/5/18 17:01
     */
    public static void getData3(Object obj) {

        try {
            Class c = obj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                System.out.println("属性:" + f.getName());
                System.out.println("值:" + f.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void getData1(String s) {
        try {
            Class c = Class.forName(s);
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("属性:" + f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void getData2() {
        Class c = Person.class;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("属性:" + f.getName());
        }
    }

    public static Map<String, Object> getDataToMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i< fields.length; i++)  {
            fields[i].setAccessible(true);
            try {
                map.put(fields[i].getName(),fields[i].get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }



    //使用反射机制，打破封装性，导致java对象属性不安全。
    public static void breakData(String cl, String m, String s) {
        Class c = null;
        try {
            c = Class.forName(cl);
            Field idf = c.getDeclaredField(m);
            //实例化这个类赋值给o
            Object o = c.newInstance();
            //打破封装
            idf.set(o,s);
            System.out.println(idf.get(o));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
