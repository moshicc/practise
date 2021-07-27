package com.zcc.algorithm_practise.reverse_linkList;

/**
 * 链表翻转
 */
public class ReverseLinkList {
    //定义一个链表
    static class ListNode{
        int val; //链表里面的值
        ListNode next; //下一个节点
        //初始化
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null, curr,next; //前一个节点、当前节点、下一个节点
        curr = head;
        while (curr != null) { //当前节点 不指向null时
            next = curr.next;
            curr.next = prev; //循环到第一个变量，翻转后head节点的next就为null了
            prev = curr; //当前节点 赋值给next（就是翻转后next指向当前的节点）
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);

       ListNode rehead = reverse(head);
    }
}
