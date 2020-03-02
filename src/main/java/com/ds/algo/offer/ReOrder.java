package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/9.
 */
public class ReOrder {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 6, 7, 9, 8, 5};
        ReOrder reOrder = new ReOrder();
        reOrder.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public void reOrderArray(int[] array) {
        int i = array.length - 1;
        int j = i;

        while (i >= 0) {
            if (array[i] % 2 == 0) {
                int temp = array[i];
                System.arraycopy(array, i + 1, array, i, j - i);
                array[j] = temp;
                j--;
            }
            i--;
        }
    }

}
