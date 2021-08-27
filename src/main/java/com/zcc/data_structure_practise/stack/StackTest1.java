package com.zcc.data_structure_practise.stack;

import java.util.Stack;

/**
 * @author zcc
 * @ClassName StackTest1
 * @description
 * @date 2021/8/23 19:42
 * @Version 1.0
 */

public class StackTest1 {
    public static void main(String[] args) {
        Stack<String > stack = new Stack<String>();
        stack.push("张三");
        stack.push("李四");
        stack.push("王五");
        stack.push("赵六");

        while (!stack.empty()) {
            String s =  stack.pop();
            System.out.println(s);
        }
    }
}
