package com.zcc.thread_practise.JUC.Function_Inface4.function;

import java.util.function.Supplier;

/**
 * @author zcc
 * @ClassName SupplierDemo
 * @description 供给型接口：没有参数，只有返回值
 * @date 2021/6/24 19:33
 * @Version 1.0
 */

public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "sssssss";
//            }
//        } ;
//        System.out.println(supplier.get());

        Supplier<String> supplier =()->"99999999";
        System.out.println(supplier.get());

    }
}
