package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/10.
 */

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 */
public class Stack2 {

    private Stack<Integer> total = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        total.push(node);
        if(minStack.empty()){
            minStack.push(node);
        } else {
            Integer min = minStack.peek();
            if(min <= node) {
                minStack.push(min);
            } else {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        total.pop();
        minStack.pop();
    }

    public int top() {
        return total.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stack2 stack = new Stack2();
        stack.push(3);
        System.out.print(stack.min());
        stack.push(4);
        System.out.print(stack.min());
        stack.push(2);
        System.out.print(stack.min());
        stack.push(3);
        System.out.print(stack.min());
        stack.pop();
        System.out.print(stack.min());
        stack.pop();
        System.out.print(stack.min());
        stack.pop();
        System.out.print(stack.min());
        stack.push(0);
        System.out.print(stack.min());
        System.out.println();
    }

}
