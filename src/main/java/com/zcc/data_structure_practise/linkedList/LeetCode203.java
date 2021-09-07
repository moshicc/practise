package com.zcc.data_structure_practise.linkedList;

import java.util.List;

/**
 * @author zcc
 * @ClassName LeetCode1
 * @description 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @date 2021/9/7 14:52
 * @Version 1.0
 */

public class LeetCode203 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,7,7,7};
        ListNode head = new ListNode(arr);
        System.out.println(head.toString());
        ListNode re = new LeetCode203().removeElements(head,7);
        System.out.println(re);

    }

    public ListNode removeElements(ListNode head, int val) {

        //判断头结点是否为待删除结点(或者头结点的下一个仍然为待删)
        while (head !=null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode = null;
        }

        //判断传进来是否为空
        if (head == null) {
            return null;
        }

        // 待删结点为中间的一个，首先要找到它前一个。
        ListNode proNode = head;
        //用proNode 代替head 进到链表中删除数据
        while (proNode.next != null) {
            if (proNode.next.val ==val) {
                ListNode delNode = proNode.next;
                proNode.next = delNode.next;
                delNode = null;
            } else {
                proNode = proNode.next;
            }
        }
        return head;
    }
}

