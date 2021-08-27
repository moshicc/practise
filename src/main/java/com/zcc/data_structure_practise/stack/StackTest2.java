package com.zcc.data_structure_practise.stack;

import java.util.Stack;

/**
 * @author zcc
 * @ClassName StackTest2
 * @description
 * @date 2021/8/23 19:48
 * @Version 1.0
 */

public class StackTest2 {
    public static void main(String[] args) {
        String s = "(])";
        System.out.println(new StackTest2().check(s));
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ((c=='(') || (c=='[') || (c=='{')) {
                stack.push(c);
            }else {
                if ((')'==c || ']' ==c || '}'==c) && stack.empty()){
                    stack.push(c);
                    break;
                }
                if (')'==c && stack.peek() =='(') {
                    stack.pop();
                }else if (']'==c && stack.peek() =='[') {
                    stack.pop();
                } else if ('}'==c && stack.peek() =='{'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();//如果最后为stack 为null 则为true ，否则为false
    }
}
