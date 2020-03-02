package com.ds.algo;

/**
 * Created by zm on 2020/1/23.
 */
public class ReverseLink {

    private Node head;
    private Node tail;

    public ReverseLink() {
        head = new Node();
        tail = head;
    }

    public boolean insert(int val) {
        Node tmp = new Node(val);
        tail.next = tmp;
        tail = tmp;
        return true;
    }

    public void reverse() {
        Node current = head.next;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        head.next = prev;
    }

    public void print() {
        Node current = head.next;
        while (current != null) {
            System.out.print(" >> " + current.val);
            current = current.next;
        }
        System.out.println(" END.");
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        int[] a = new int[] {2, 5, 1, 8, 6, 19, 11, 13};
        for (int val : a) {
            reverseLink.insert(val);
        }
        reverseLink.print();

        reverseLink.reverse();
        reverseLink.print();
    }

}
