package com.ds.algo.company;

import java.util.*;

/**
 * Created by zm on 2020/12/11.
 */
public class A {

    public static void main(String[] args) {
        System.out.println(new A().aa(new int[]{3,2}));
    }

    public double aa(int[] nums) {
        int n = nums.length;
        double base = 1.0 * n * (n + 1) / 2;
        double ans = 0;

        Stack<Integer> st = new Stack<>();
        double[] dp = new double[nums.length];

        for (int i = 0; i < n; i++) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
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
