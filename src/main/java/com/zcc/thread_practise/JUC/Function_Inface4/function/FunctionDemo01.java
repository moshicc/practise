package com.zcc.thread_practise.JUC.Function_Inface4.function;

import java.util.function.Function;

/**
 * @author zcc
 * @ClassName FunctionDemo01
 * @description 函数式接口：只有一个抽象方法的接口
 * 函数式接口可以被隐式转换为Lambda表达式。
 * 函数式接口可以用@FunctionalInterface注解标识。
 * @date 2021/6/24 16:34
 * @Version 1.0
 */
/**
 * Function 函数型接口, 有一个输入参数，有一个输出
 * 只要是 函数型接口 可以 用 lambda表达式简化
 */

public class FunctionDemo01 {
    public static void main(String[] args) {
//        Function<Object, Object> function = new Function<Object, Object>() {
//            @Override
//            public Object apply(Object o) {
//                if (o instanceof String) {
//                    o = ((String) o).concat("11111112222");
//                }
//                System.out.println("gggggg");
//                return o;
//            }
//        };
//        System.out.println(function.apply("cccccc"));
        Function function = (a)->{ return a; };
        System.out.println(function.apply(2222));
    }
}
