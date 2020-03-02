package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/14.
 */
public class NumberAppearOnce {

    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        int result = 0;
        for (int val : array) {
            result ^= val;
        }
        int index = 0;
        while (((result >> index) & 1) != 1 && index < 32) {
            index++;
        }

        num1[0] = 0;
        num2[0] = 0;
        for (int val : array) {
            if (((val >> index) & 1) == 1) {
                num1[0] = num1[0] ^ val;
            } else {
                num2[0] = num2[0] ^ val;
            }
        }
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        List<Integer> list = new ArrayList<>(2);
        for (int val : array) {
            int index = list.indexOf(val);
            if (index != -1) {
                list.remove(index);
            } else {
                list.add(val);
            }
        }
        num1[0] = list.get(0);
        num1[0] = list.get(1);
    }

}
