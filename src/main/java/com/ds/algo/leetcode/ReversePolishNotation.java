package com.ds.algo.leetcode;

import java.util.*;

/**
 * Created by zm on 2020/2/23.
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation reverse = new ReversePolishNotation();
        //String tokens = "2,1,+,3,*";
        String tokens = "4,13,5,/,+";
        System.out.println(reverse.evalRPN(tokens.split(",")));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num4 = stack.pop();
                    int num3 = stack.pop();
                    stack.push(num3 / num4);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        if (stack.size() > 1) {
            return -1;
        }
        return stack.pop();
    }
}
