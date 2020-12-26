package com.ds.algo.statck;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * Leetcode 739
 */
public class NextWarnWeather {

    public static void main(String[] args) {
        NextWarnWeather nextWarnWeather = new NextWarnWeather();
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(nextWarnWeather.dailyTemperatures(nums)));
    }

    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        if (T.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.empty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return result;
    }
}
