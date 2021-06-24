package com.zcc.thread_practise.JUC.Function_Inface4.function;

import java.util.function.Consumer;

/**
 * @author zcc
 * @ClassName ConsumerDemo
 * @description 消费型接口：只有输入，没有返回值
 * @date 2021/6/24 19:29
 * @Version 1.0
 */

public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("55555555555555555555");
        Consumer<String> consumer = (o)->{System.out.println(o);};
        consumer.accept("sadasdasdaa");
    }
}
