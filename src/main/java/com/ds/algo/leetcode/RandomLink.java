package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/3/8.
 */
public class RandomLink {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        RandomLink randomLink = new RandomLink();
        RandomListNode newNode = randomLink.copyRandomList(node1);
        randomLink.print(newNode);
        randomLink.print(node1);

    }

    public void print(RandomListNode head) {
        while (head != null) {
            System.out.print(head.label + " ");
            head = head.next;
        }
        System.out.println();
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode next = node.next;

            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = next;
            node.next = cloneNode;
            node = next;
        }
        node = head;
        while (node != null) {
            RandomListNode cloneNode = node.next;

            RandomListNode randomNode = node.random;
            if (randomNode != null) {
                cloneNode.random = randomNode.next;
            }
            node = node.next.next;
        }
        node = head;
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode newCurrent = newHead;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            RandomListNode oriNodeNext = node.next.next;
            newCurrent.next = cloneNode;
            node.next = oriNodeNext;

            newCurrent = cloneNode;
            node = oriNodeNext;
        }
        return newHead.next;
    }

    static class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;

}
