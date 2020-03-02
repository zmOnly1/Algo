package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class CountOneNumber {

    public static void main(String[] args) {
        CountOneNumber countOneNumber = new CountOneNumber();
        System.out.println(countOneNumber.NumberOf1Between1AndN_Solution(11));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0, len = s.length(); j < len; j++) {
                if(s.charAt(j) == '1')count++;
            }
        }
        return count;
    }

}
