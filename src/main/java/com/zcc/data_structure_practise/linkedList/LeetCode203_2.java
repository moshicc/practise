package com.zcc.data_structure_practise.linkedList;

/**
 * @author zcc
 * @ClassName LeetCode203_2
 * @description 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @date 2021/9/7 18:56
 * @Version 1.0
 */

//使用虚拟头结点
public class LeetCode203_2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,3,4,5,6};
        int[] arr1 = new int[]{7,7,7,7};
        ListNode head = new ListNode(arr1);
        System.out.println(head.toString());
        ListNode re = new LeetCode203_2().removeElements(head,7);
        System.out.println(re);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next =head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
