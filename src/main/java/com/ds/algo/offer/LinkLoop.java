package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/16.
 */
public class LinkLoop {

    /**
     * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
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
