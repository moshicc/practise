package com.zcc.data_structure_practise.stack;

import java.util.Stack;

/**
 * @author zcc
 * @ClassName MyQueue
 * @description
 * @date 2021/8/25 10:43
 * @Version 1.0
 */

class MyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);

        System.out.println("head:" + queue.empty());
    }
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer result ;
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.empty()) {
            int temp = stack.pop();
            tempStack.push(temp);
        }
        result = tempStack.pop();

        while (!tempStack.empty()) {
            int temp = tempStack.pop();
            stack.push(temp);
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        Integer result ;
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.empty()) {
            int temp = stack.pop();
            tempStack.push(temp);
        }
        result = tempStack.peek();
        while (!tempStack.empty()) {
            int temp = tempStack.pop();
            stack.push(temp);
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
