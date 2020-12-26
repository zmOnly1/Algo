package com.ds.algo.company;

import java.util.*;

public class Solution {

    /**
     * @param nums: a list of positive numbers
     * @return: the expectation of the maximum number
     */
    public double expectMaximum(int[] nums) {
        int n = nums.length;
        double base = 1.0 * n * (n + 1) / 2;
        double ans = 0;

        Stack<Integer> st = new Stack<Integer>();
        double[] dp = new double[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            int j = st.empty() ? -1 : st.peek();
            dp[i] = 1.0 * (i - j) * nums[i] / base;

            if (j != -1) {
                dp[i] += dp[j];
            }
            ans += dp[i];
            st.push(i);
        }
        return ans;
    }
}