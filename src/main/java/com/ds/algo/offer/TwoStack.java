package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/10.
 */

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class TwoStack {

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        //int[] popA = new int[]{4,5,3,2,1};
        int[] popA = new int[]{4,3,5,1,2};
        TwoStack twoStack = new TwoStack();
        System.out.println(twoStack.IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        int size = pushA.length;
        while (i < size) {
            if (!stack.empty()) {
                int pop = popA[j];
                Integer top = stack.peek();
                if (pop == top) {
                    stack.pop();
                    j++;
                }
            }
            stack.push(pushA[i]);
            i++;
        }
        while (!stack.empty() && j < size){
            Integer pop = stack.pop();
            if(pop != popA[j]){
                return false;
            }
            j++;
        }
        return j == size;
    }
}
