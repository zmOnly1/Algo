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
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    public static boolean isNumeric(char[] str) {
        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);
    }

}
