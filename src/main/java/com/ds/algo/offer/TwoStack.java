package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/10.
 */

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
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
