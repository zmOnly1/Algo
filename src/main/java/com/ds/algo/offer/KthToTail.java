package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class KthToTail {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(k <= 0){
            return null;
        }

        int i = 1;
        ListNode node = head;
        while (i < k && node != null) {
            node = node.next;
            i++;
        }
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            head = head.next;
            node = node.next;
        }

        return head;
    }


    class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
