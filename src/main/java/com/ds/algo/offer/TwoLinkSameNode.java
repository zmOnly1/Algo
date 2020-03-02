package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/12.
 */
public class TwoLinkSameNode {

    public static void main(String[] args) {

        TwoLinkSameNode sameNode = new TwoLinkSameNode();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode nodea = new ListNode(7);
        ListNode nodeb = new ListNode(8);
        nodea.next = nodeb;
        nodeb.next = node4;

        System.out.println(sameNode.FindFirstCommonNode(node1, nodea));
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if(p1 != p2){
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }

        }
        return p1;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        Map<ListNode, ListNode> map = new HashMap<>();
        while (pHead1 != null) {
            map.put(pHead1, pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (map.containsKey(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }


    }

}
