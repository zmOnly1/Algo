package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/15.
 */
public class ContinueNumber {

    public static void main(String[] args) {
        ContinueNumber continueNumber = new ContinueNumber();
        int[] numbers = new int[] {1, 3, 2, 6, 4};
        System.out.println(continueNumber.isContinuous(numbers));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        if (hasRepeatNumber(numbers)) {
            return false;
        }
        int i = getNonZeroIndex(numbers);
        if (i == 4) {
            return true;
        }
        int min = numbers[i];
        int max = numbers[numbers.length - 1];
        if (max <= 9) {
            return max - min <= 4;
        } else {
            return max - min <= 4 || min + 13 - max <= 4;
        }
    }

    private boolean hasRepeatNumber(int[] numbers) {
        int i = getNonZeroIndex(numbers);
        int len = numbers.length;
        while (i < len - 1) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    private int getNonZeroIndex(int[] numbers) {
        int i = 0;
        while (i < numbers.length && numbers[i] == 0) {
            i++;
        }
        return i;
    }

}
