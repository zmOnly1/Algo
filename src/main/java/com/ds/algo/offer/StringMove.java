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
     * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ������������
     * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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
