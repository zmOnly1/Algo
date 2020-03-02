package com.ds.algo;

/**
 * Created by zm on 2020/1/23.
 */
public class LRUBaseLink {

    private int capacity = 5;
    private int count = 0;
    private Node head;


    public LRUBaseLink() {
        head = new Node();
        head.next = null;
    }

    public boolean add(int val) {
        Node node = findNode(val);
        if (node != null) {
            moveToFirst(node);
        } else {
            Node newNode = new Node(val);
            if (count == capacity) {
                insertToFirstAndRemoveLast(newNode);
            } else {
                inertToFirst(newNode);
                count++;
            }
        }
        return false;
    }

    private void insertToFirstAndRemoveLast(Node newNode) {
        removeLast();
        inertToFirst(newNode);
    }

    private void removeLast() {
        Node parent = head;
        Node child = head.next;
        while (child != null) {
            if (child.next == null) {
                parent.next = null;
                return;
            }
            parent = child;
            child = child.next;
        }
    }

    private void printAll() {
        Node current = head.next;
        while (current != null) {
            System.out.print(current.val + " >> ");
            current = current.next;
        }
        System.out.println(" End.");
    }

    private void inertToFirst(Node newNode) {
        Node tmp = head.next;
        head.next = newNode;
        newNode.next = tmp;
    }

    private void moveToFirst(Node node) {
        Node preNode = findPreNode(node);
        assert preNode != null;
        Node tmp = node.next;
        node.next = head.next;
        head.next = node;
        preNode.next = tmp;
    }

    private Node findPreNode(Node node) {
        Node parent = head;
        Node child = head.next;
        while (child != null) {
            if (child == node) {
                return parent;
            }
            parent = child;
            child = child.next;
        }
        return null;
    }

    private Node findNode(int val) {
        Node current = head.next;
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LRUBaseLink lruBaseLink = new LRUBaseLink();
        int[] a = new int[] {27, 14, 2, 14, 11, 27, 56, 2, 15, 2};
        for (int val: a){
            lruBaseLink.add(val);
            lruBaseLink.printAll();
        }
    }

}
