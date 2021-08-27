package com.zcc.data_structure_practise.stack;

import java.util.List;
import java.util.Stack;

/**
 * @author zcc
 * @ClassName StackTest3
 * @description 回文链表
 * @date 2021/8/24 19:18
 * @Version 1.0
 */
//[1,2,2,1]
public class StackTest3 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1,null);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        boolean b = new StackTest3().isPalindrome(node1);
        System.out.println(b);

    }
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node1 = head;
        ListNode node2 = head;

        while (node1 != null) {
            //将链表放入栈中，当然，链表尾巴在栈顶
            stack.push(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            //如果链表的头 和 stack的顶（就是链表的尾巴）不相等，返回false
            if (node2.val != stack.peek()){
                return false;
            }else {
                //不然就弹出stack的顶，链表也下移一位。
                stack.pop();
                node2 = node2.next;
            }
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
