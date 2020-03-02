package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/15.
 */
public class StringMove {

    public static void main(String[] args) {
        StringMove stringMove = new StringMove();
        System.out.println(stringMove.LeftRotateString("abcXYZdef", 3));
        System.out.println(stringMove.ReverseSentence(" "));
    }

    public String ReverseSentence(String str) {
        if(str == null || str.trim().length() == 0){
            return str;
        }
        StringBuilder builder = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0 ; i--) {
            builder.append(strings[i]);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public String LeftRotateString(String str, int n) {
        if(str == null || str.length() == 0){
            return "";
        }
        int len = str.length();
        int head = 0;

        head = (head + n) % len;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        while (count < len) {
            builder.append(str.charAt(head));
            head = (head + 1) % len;
            count++;
        }
        return builder.toString();
    }
}
