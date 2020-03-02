package com.ds.algo.offer;

import java.util.*;
import java.util.regex.*;

/**
 * Created by zm on 2020/2/16.
 */
public class StringIsNumber {

    public static void main(String[] args) {
        StringIsNumber isNumber = new StringIsNumber();

        String abc = "aEbec";
        System.out.println(Arrays.toString(abc.split("[e|E]")));

        Pattern p = Pattern.compile("[0-9a-z]{2}(?=aa)");
        String str = "aaaaaaaa";

        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }
    }

    /**
     * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
     * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
     * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
     */
    public static boolean isNumeric(char[] str) {
        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);
    }

}
