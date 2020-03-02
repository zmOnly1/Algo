package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/2/26.
 */
public class LinkReOrder {

    public static void main(String[] args) {
        LinkReOrder linkReOrder = new LinkReOrder();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        linkReOrder.reorderList(head);
        linkReOrder.print(head);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode midNode = getMidNode(head);

        ListNode midNext = midNode.next;
        midNode.next = null;
        ListNode second = reverseLink(midNext);
        mergeTwoLink(head, second);
    }

    private void mergeTwoLink(ListNode first, ListNode second) {
        int i = 1;
        while (first != null) {
            if (i % 2 == 1) {
                ListNode firstNext = first.next;
                first.next = second;
                first = firstNext;
            } else {
                ListNode secondNext = second.next;
                second.next = first;
                second = secondNext;
            }
            i++;
        }
    }

    private ListNode reverseLink(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
