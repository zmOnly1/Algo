package com.ds.algo;

import java.util.*;

/**
 * Created by zm on 2020/2/23.
 */
public class Sum24 {

    private char[] optList = new char[] {'+', '-', '*', '/'};

    public List<String> sum24(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length != 4) {
            return result;
        }
        List<Integer> numlist = new ArrayList<>(nums.length);
        for (int num : nums) {
            numlist.add(num);
        }
        StringBuilder formula = new StringBuilder();
        recursive(numlist, formula, result);

        return result;
    }

    private void recursive(List<Integer> numlist, StringBuilder formula, List<String> result) {
        if (numlist.size() == 1) {
            formula.append(numlist.get(0));
            String formulaStr = formula.toString();
            if (sum(formulaStr) == 24) {
                result.add(formulaStr);
            }
            formula.deleteCharAt(formula.length() - 1);
            return;
        }

        for (int i = 0, size = numlist.size(); i < size; i++) {
            Integer num = numlist.get(i);
            formula.append(num);
            numlist.remove(i);
            for (char c : optList) {
                formula.append(c);
                recursive(numlist, formula, result);
                formula.deleteCharAt(formula.length() - 1);
            }
            numlist.add(i, num);
            formula.deleteCharAt(formula.length() - 1);
        }
    }

    public static void main(String[] args) {
        Sum24 sum24 = new Sum24();
        //System.out.println(sum24.sum("1+3*6+5"));
        int[] nums = {9, 3, 5, 6};
        System.out.println(sum24.sum24(nums));
    }

    public int sum(String optString) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opts = new Stack<>();
        for (int i = 0, len = optString.length(); i < len; i++) {
            char c = optString.charAt(i);
            if (c >= '0' && c <= '9') {
                nums.push(c - '0');
            } else {
                while (!opts.isEmpty() && !isPriorityOpt(opts.peek(), c)) {
                    nums.push(sumStack(nums, opts));
                }
                opts.push(c);
            }
        }

        while (!opts.isEmpty()) {
            nums.push(sumStack(nums, opts));
        }
        if (nums.size() == 1) {
            return nums.pop();
        }
        throw new IllegalArgumentException("Invalid string:" + optString);
    }

    private int sumStack(Stack<Integer> nums, Stack<Character> opts) {
        Character opt = opts.pop();
        int num2 = nums.pop();
        int num1 = nums.pop();
        switch (opt) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        throw new IllegalArgumentException("invalid opt:" + opt);
    }

    private boolean isPriorityOpt(Character stackTopOpt, char newOpt) {
        return (newOpt == '*' || newOpt == '/') && (stackTopOpt == '+' || stackTopOpt == '-');
    }
}
