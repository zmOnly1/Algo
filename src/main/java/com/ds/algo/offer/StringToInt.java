package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/15.
 */
public class StringToInt {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        StringToInt stringToInt = new StringToInt();
        System.out.println(stringToInt.StrToInt("-2147483649"));
    }

    public int StrToInt(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int firstIndex = 0;
        char firstChar = str.charAt(0);
        boolean negative = false;
        if (firstChar == '+' || firstChar == '-') {
            negative = firstChar == '-';
            firstIndex = 1;
        }
        int result = 0;
        int exp = 1;
        int len = str.length();
        for (int i = len - 1; i >= firstIndex; i--) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return 0;
            }
            int multiple = (c - '0') * exp;
            if (negative) {
                if(Integer.MIN_VALUE + multiple > -result){
                    return 0;
                }
            } else {
                if(Integer.MAX_VALUE - multiple < result){
                    return 0;
                }
            }
            result += multiple;
            exp *= 10;
        }
        return firstChar == '-' ? -result : result;
    }

}
