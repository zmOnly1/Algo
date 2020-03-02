package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/15.
 */
public class Multiple {

    public static void main(String[] args) {
        Multiple multiple = new Multiple();
        int[] arrays = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiple.multiply(arrays)));
    }

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        B[A.length - 1] = 1;
        for (int i = 1, len = A.length; i < len - 1; i++) {
            B[i] = 1;
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }

}
