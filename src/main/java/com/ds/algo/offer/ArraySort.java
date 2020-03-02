package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/11.
 */
public class ArraySort {

    public static void main(String[] args) {
        String abc = "aab";

        ArraySort arraySort = new ArraySort();
        ArrayList<String> permutation = arraySort.Permutation(abc);
        System.out.println(permutation);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        sort(list, builder, str);
        return list;
    }

    private void sort(ArrayList<String> list, StringBuilder builder, String str) {
        if (str.length() == 1) {
            builder.append(str);
            String s = builder.toString();
            if (!list.contains(s)) {
                list.add(s);
            }
            builder.deleteCharAt(s.length() - 1);
            return;
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            builder.append(c);

            String last = str.substring(0, i) + str.substring(i + 1, len);
            sort(list, builder, last);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 1){
            return array[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int count = map.get(i) + 1;
                if (count > array.length / 2) {
                    return i;
                }
                map.put(i, count);
            } else {
                map.put(i, 1);
            }
        }
        return 0;
    }

}
