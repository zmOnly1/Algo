package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/16.
 */
public class LinkLoop {

    /**
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Map<ListNode, Integer> existNode = new HashMap<>();
        int index = 0;
        ListNode node = pHead;
        while (node != null) {
            if (existNode.containsKey(node)) {
                return node;
            }
            existNode.put(node, ++index);
            node = node.next;
        }
        return null;
    }

    class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
