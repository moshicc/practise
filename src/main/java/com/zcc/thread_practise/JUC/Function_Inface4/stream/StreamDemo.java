package com.zcc.thread_practise.JUC.Function_Inface4.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zcc
 * @ClassName StreamDemo
 * @description 特性：
 *          1.Stream流不是一种数据结构，不保存数据，它只是在原数据集上定义了一组操作。
 *          2.这些操作是惰性的，即每当访问到流中的一个元素，才会在此元素上执行这一系列操作。
 *          3.Stream不保存数据，故每个Stream流只能使用一次。
 * @date 2021/6/24 19:45
 * @Version 1.0
 */

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("mango");
        list.add("peach");
        //forEach传入的是一个Consumer 只有输入，没有返回值
//        Consumer<String> consumer = (s)->{
//            System.out.println(s);
//        };
        List<String> list2 = new ArrayList<>();
        list.forEach((index) -> {
            System.out.println(index);
            list2.add(index + "444");
        });

        for (String aa : list2){
            System.out.println(aa);
        }
    }
}
