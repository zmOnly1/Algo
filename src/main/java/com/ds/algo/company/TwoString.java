package com.ds.algo.company;

import java.util.*;

/**
 * Created by zm on 2020/12/11.
 */
public class TwoString {

    public static void main(String[] args) {
        TwoString twoString = new TwoString();
        //System.out.println(twoString.isIsomorphic("egg", "add"));
        //System.out.println(twoString.isIsomorphic("foo", "bar"));
        //System.out.println(twoString.isIsomorphic("abcd", "eeee"));
        //System.out.println(twoString.isIsomorphic("abc", "far"));
        //System.out.println(twoString.isIsomorphic("paper", "title"));
        //System.out.println(twoString.isIsomorphic("ab", "aa"));
        //System.out.println(twoString.isIsomorphic2("ab", "aa"));
        System.out.println(twoString.isIsomorphic3("ab", "aa"));
        System.out.println(twoString.isIsomorphic3("abc", "far"));
        //System.out.println(twoString.isIsomorphic2("abc", "far"));
        //System.out.println(twoString.isIsomorphic2("paper", "title"));

        //System.out.println(twoString.zero("00010011"));
        //System.out.println(twoString.origin(3, 2));
        //System.out.println(twoString.origin(2, 4));
        //System.out.println(twoString.origin(4, 2));

    }

    public int origin(int steps, int arrLen) {
        int[] allResult = new int[] {0};
        keepStep(steps, 0, arrLen, allResult);
        return allResult[0];
    }

    public void keepStep(int steps, int result, int length, int[] allResult) {
        if (steps == 0) {
            if (result == 0) {
                allResult[0] = (allResult[0] + 1) % (1000000000 + 7);
            }
            return;
        }
        if (0 <= (result - 1) && (result - 1) < length) {
            keepStep(steps - 1, (result - 1), length, allResult);
        }
        if (0 <= result && result < length) {
            keepStep(steps - 1, result, length, allResult);
        }
        if (0 <= (result + 1) && (result + 1) < length) {
            keepStep(steps - 1, (result + 1), length, allResult);
        }
    }

    public int zero(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String[] strings = str.split("1");
        int result = 0;
        for (String string : strings) {
            int len = string.length();
            result += (len * (len + 1)) / 2;
        }
        return result;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (!map1.containsKey(ss) && !map2.containsKey(tt)) {
                map1.put(ss, i);
                map2.put(tt, i);
            } else {
                if (map1.get(ss) != map2.get(tt)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return detection(s).equals(detection(t));
    }

    public String detection(String s) {
        StringBuffer str = new StringBuffer();
        str.append('A');
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            int a = judge(s, i);
            if (a == -1) {
                str.append((char) (65 + count));
                count++;
            } else {
                str.append(str.charAt(a));
            }
        }
        return str.toString();
    }

    public int judge(String s, int i) {
        for (int j = 0; j < i; j++) {
            if (s.charAt(i) == s.charAt(j)) {
                return j;
            }
        }
        return -1;
    }


}
