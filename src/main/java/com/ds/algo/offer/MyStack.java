package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/10.
 */

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MyStack {

    private java.util.Stack<Integer> stack = new java.util.Stack<>();
    private int[] array = new int[0];
    private int size = 0;

    public void push(int node) {
        stack.push(node);
        enCapacity(size + 1);
        insertSort(node);
        size++;
    }

    private void insertSort(int node) {
        int i = 0;
        while (i < size && array[i] < node) {
            i++;
        }
        if(i < size){
            System.arraycopy(array, i, array, i + 1, size - i);
        }
        array[i] = node;

    }

    private void enCapacity(int newSize) {
        int[] tmp = new int[newSize];
        System.arraycopy(array, 0, tmp, 0, array.length);
        array = tmp;
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        Integer pop = stack.pop();
        int idx = findIndex(pop);
        arrayRemove(idx);
        size--;
    }

    private void arrayRemove(int idx) {
        int[] tmp = new int[size - 1];
        if (idx > 0) {
            System.arraycopy(array, 0, tmp, 0, idx);
        }
        if (idx < size - 1) {
            System.arraycopy(array, idx + 1, tmp, idx, size - idx - 1);
        }
        array = tmp;
    }

    private int findIndex(Integer val) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] == val) {
                return mid;
            } else if (array[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int top() {
        return 0;
    }

    public int min() {
        if (stack.empty()) {
            return 0;
        }
        return array[0];
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.print(myStack.min());
        myStack.push(4);
        System.out.print(myStack.min());
        myStack.push(2);
        System.out.print(myStack.min());
        myStack.push(3);
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        myStack.push(0);
        System.out.print(myStack.min());
        System.out.println();
    }

}
