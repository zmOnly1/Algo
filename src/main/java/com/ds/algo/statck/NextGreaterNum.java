package com.ds.algo.statck;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * Leetcode 496
 */
public class NextGreaterNum {

    public static void main(String[] args) {
        NextGreaterNum nextGreaterNum = new NextGreaterNum();
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterNum.nextGreaterElement(nums1, nums2)));

        nums1 = new int[]{2,4};
        nums2 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterNum.nextGreaterElement(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null){
            return null;
        }
        int[] result = new int[nums1.length];
        if(nums1.length == 0){
            return result;
        }
        Map<Integer, Integer> rightIndex = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int j : nums2) {
            while (!stack.empty() && j > stack.peek()) {
                Integer topNum = stack.pop();
                rightIndex.put(topNum, j);
            }
            stack.push(j);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = rightIndex.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
