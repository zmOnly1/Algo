package com.ds.algo.statck;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * leetcode 503
 */
public class NextGreaterNum2 {

    public static void main(String[] args) {
        NextGreaterNum2 nextGreaterNum2 = new NextGreaterNum2();
        int[] nums = new int[] {1, 2, 1};
        int[] nums2 = new int[] {1, 2, 3,4,5};
        int[] nums3 = new int[] {1, 2, 3, 2, 1};
        int[] nums4 = new int[] {-1, 0};
        System.out.println(Arrays.toString(nextGreaterNum2.nextGreaterElements(nums)));
        System.out.println(Arrays.toString(nextGreaterNum2.nextGreaterElements(nums2)));
        System.out.println(Arrays.toString(nextGreaterNum2.nextGreaterElements(nums3)));
        System.out.println(Arrays.toString(nextGreaterNum2.nextGreaterElements(nums4)));
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        Integer[] result = new Integer[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.empty() && nums[i % n] > nums[stack.peek()]) {
                Integer topIndex = stack.pop();
                result[topIndex] = nums[i % n];
            }
            stack.push(i % n);
        }
        while (!stack.empty()) {
            Integer topIndex = stack.pop();
            if (result[topIndex] != null) {
                continue;
            }
            result[topIndex] = -1;
        }
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
