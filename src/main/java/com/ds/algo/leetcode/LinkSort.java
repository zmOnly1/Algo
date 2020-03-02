package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/2/25.
 */
public class LinkSort {

    public static void main(String[] args) {
        LinkSort linkSort = new LinkSort();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        linkSort.print(node1);
        linkSort.print(linkSort.sortList(node1));
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode next = current.next;

            ListNode prev = null;
            ListNode sortCurrent = head;
            while (sortCurrent != null && current.val > sortCurrent.val) {
                prev = sortCurrent;
                sortCurrent = sortCurrent.next;
            }
            if (prev == null) {
                current.next = head;
                head = current;
            } else {
                prev.next = current;
                current.next = sortCurrent;
            }
            current = next;
        }
        return head;
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
