package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/9.
 */
public class LinkConverse {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(0, 1);
        list.add(0, 2);

        System.out.println(list);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
