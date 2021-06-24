package com.zcc.thread_practise.JUC.Function_Inface4.function;

import java.util.function.Predicate;

/**
 * @author zcc
 * @ClassName PredicateDemo
 * @description 断定型接口：有一个输入参数，返回值只能是一个布尔值。
 * @date 2021/6/24 19:13
 * @Version 1.0
 */

public class PredicateDemo {
    public static void main(String[] args) {
//        Predicate predicate = new Predicate() {
//            @Override
//            public boolean test(Object o) {
//                if (o instanceof String)
//                    return true;
//                return false;
//            }
//        };
//        System.out.println(predicate.test(55));
        Predicate<String> predicate = (o)->{
          return o.isEmpty();
        };
        System.out.println(predicate.test(""));
    }
}
