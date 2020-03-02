package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/16.
 */
public class LinkRepeatNode {

    public static void main(String[] args) {
        LinkRepeatNode linkRepeatNode = new LinkRepeatNode();
        //ListNode node1 = new ListNode(1);
        //ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node31 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node41 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //node1.next = node2;
        //node2.next = node3;
        node3.next = node31;
        node31.next = node4;
        node4.next = node41;
        node41.next = node5;
        ListNode pHead = node3;
        ListNode node = linkRepeatNode.deleteDuplication(pHead);
        linkRepeatNode.print(node);
    }

    private void print(ListNode pHead){
        while (pHead != null){
            System.out.print(pHead.val);
            pHead = pHead.next;
        }
        System.out.println();
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode prev = null;
        ListNode node = pHead;
        while (node != null && node.next != null) {
            if (node.val != node.next.val) {
                prev = node;
            } else {
                node = node.next;
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    pHead = node.next;
                }
            }
            node = node.next;
        }
        return pHead;
    }

    static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
