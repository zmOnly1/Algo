package com.ds.algo.statck;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * Leetcode 42
 */
public class TrapRain {

    public static void main(String[] args) {
        int[] heights = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heights2 = new int[] {4, 2, 0, 3, 2, 5};
        TrapRain trapRain = new TrapRain();
        System.out.println(trapRain.trap(heights));
        System.out.println(trapRain.trap(heights2));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int rightIdx = 0; rightIdx < height.length; rightIdx++) {
            while (!stack.empty() && height[rightIdx] > height[stack.peek()]) {
                Integer topIndex = stack.pop();
                if (!stack.empty()) {
                    Integer leftIndex = stack.peek();
                    int min = Math.min(height[rightIdx], height[leftIndex]);
                    int trapHeight = (rightIdx - leftIndex - 1) * (min - height[topIndex]);
                    ans += trapHeight;
                }
            }
            stack.push(rightIdx);
        }
        return ans;
    }
}
