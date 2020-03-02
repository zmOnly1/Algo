package com.ds.algo;

/**
 * Created by zm on 2020/1/23.
 */
public class MergeTwoSortLink {

    private Node head;
    private Node tail;

    public MergeTwoSortLink() {
        head = new Node();
        tail = head;
    }

    public boolean sortInsert(int val) {
        Node newNode = new Node(val);

        Node parent = head;
        Node child = head.next;
        while (child != null) {
            if (child.val > val) {
                break;
            }
            parent = child;
            child = child.next;
        }
        parent.next = newNode;
        newNode.next = child;
        return true;
    }

    public Node mergeLink(Node link1, Node link2) {
        Node curr1 = link1.next;
        Node curr2 = link2.next;

        Node newHead;
        if (curr1.val < curr2.val) {
            newHead = link1;
        } else {
            newHead = link2;
        }
        Node tail = newHead;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                tail.next = curr1;
                tail = curr1;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                tail = curr2;
                curr2 = curr2.next;
            }
        }

        if (curr1 != null) {
            tail.next = curr1;
        }
        if (curr2 != null) {
            tail.next = curr2;
        }
        return newHead;
    }

    public void print() {
        Node current = head.next;
        while (current != null) {
            System.out.print(" >> " + current.val);
            current = current.next;
        }
        System.out.println(" END.");
    }

    public void print(Node head) {
        Node current = head.next;
        while (current != null) {
            System.out.print(" >> " + current.val);
            current = current.next;
        }
        System.out.println(" END.");
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 5, 1, 8, 6, 19, 11, 13};
        MergeTwoSortLink soreLink1 = new MergeTwoSortLink();
        for (int val : a) {
            soreLink1.sortInsert(val);
        }
        soreLink1.print();

        int[] a2 = new int[] {8, 6, 19, 11, 13, 18, 4, 1, 4};
        MergeTwoSortLink soreLink2 = new MergeTwoSortLink();
        for (int val : a2) {
            soreLink2.sortInsert(val);
        }
        soreLink2.print();

        Node node = soreLink2.mergeLink(soreLink1.head, soreLink2.head);
        soreLink2.print(node);
    }

}
