package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/18.
 */
public class MaxInWindow {

    public static void main(String[] args) {
        int[] num = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        MaxInWindow maxInWindow = new MaxInWindow();
        System.out.println(maxInWindow.maxInWindows(num, size));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        while (i < size) {
            queue.add(num[i]);
            i++;
        }
        result.add(queue.peek());
        while (i < num.length) {
            queue.remove(num[i - size]);
            queue.add(num[i]);
            result.add(queue.peek());
            i++;
        }
        return result;
    }

}
