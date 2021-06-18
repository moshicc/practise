package com.zcc.collection_practise;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author zcc
 * @ClassName Iterator_demo1
 * @description 迭代器操作
 * 迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，
 * 而开发人员不需要了解该序列的底层结构。迭代器通常被称为“轻量级”对象，因为创建它的代价小。
 * 　　Java中的Iterator功能比较简单，并且只能单向移动：
 * 　　(1) 使用方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，
 * 它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。
 * 　　(2) 使用next()获得序列中的下一个元素。
 * 　　(3) 使用hasNext()检查序列中是否还有元素。
 * 　　(4) 使用remove()将迭代器新返回的元素删除。
 * @date 2021/5/13 14:15
 * @Version 1.0
 */

public class Iterator_demo1 {
    public static void main(String[] args) {
//        Map<Integer, Object> map = createMap();
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        Set<Integer> set = createSet();
//        Object[] list = set.toArray();
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }
        List<Integer> arr = Arrays.asList(1,2,3);
        List arr1 = new ArrayList();
        System.out.println("arr:"+arr);
        //因为Arrays.asList创建的是一个Arrays类里ArrayList对象（这个内部类里面内有add方法，就使用它父类的add方法），它继承的抽象类AbstractList里面并没有实现remove、add方法，
        //而正常的ArrayList类里面是实现了add方法的
        // 底层调用的抽象方法并没有实现remove方法，而是直接抛出异常
 //        arr.remove(1);
//        System.out.println(arr);
        //解决办法，把它传入另外一个ArrayList对象，但是对另外一个list集合对象的操作，不会影响原List集合对象内的数据。
        List<Integer> arr2 = new ArrayList<Integer>(arr);
        arr2.remove(1);
        System.out.println("arr:"+arr);
        System.out.println("arr2:"+arr2);


    }

    public static Map<Integer, Object> createMap(){
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i,i + "AA");
        }
        return map;
    }

    public static Set createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
        return set;
    }
}
