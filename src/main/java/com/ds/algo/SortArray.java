package com.ds.algo;

import java.util.*;

/**
 * Created by zm on 2020/1/22.
 */
public class SortArray {

    private int[] data;
    private int count;

    public SortArray() {
        data = new int[10];
        count = 0;
    }

    public boolean add(int val) {
        if (count == data.length) {
            return false;
        }
        int index = findFirstGreaterThan(val);
        if(index == -1){
            data[count++] = val;
            return true;
        }

        for (int i = count - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = val;
        count++;
        return true;
    }

    private int findIndex(int val) {
        for (int i = 0; i < count; i++) {
            if (data[i] > val) {
                return i;
            }
        }
        return count;
    }

    private int findFirstGreaterThan(int val) {
        int low = 0;
        int high = count;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > val) {

                if (mid == 0 || data[mid - 1] < val) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        int[] a = new int[] {1, 3, 2, 8, 7, 11, 15, 6, 35, 16, 9, 77, 57};
        for (int value : a) {
            sortArray.add(value);
        }
        System.out.println(Arrays.toString(sortArray.data));

        SortArray sortArray2 = new SortArray();
        int[] b = new int[] {2, 8, 7, 11, 16, 9, 77, 57, 1, 3, 15, 6, 35};
        for (int value : b) {
            sortArray2.add(value);
        }
        System.out.println(Arrays.toString(sortArray2.data));

        int[] mergeArray = sortArray2.mergeArray(sortArray.data, sortArray2.data);
        System.out.println(Arrays.toString(mergeArray));
    }

    public int[] mergeArray(int[] a1, int[] a2) {
        int alSize = a1.length;
        int a2Size = a2.length;
        int[] mergeArray = new int[alSize + a2Size];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < alSize && j < a2Size) {
            if (a1[i] < a2[j]) {
                mergeArray[k++] = a1[i];
                i++;
            } else {
                mergeArray[k++] = a2[j];
                j++;
            }
        }
        if (i < alSize) {
            while (i < alSize) {
                mergeArray[k++] = a1[i];
                i++;
            }
        }
        if (j < alSize) {
            while (j < a2Size) {
                mergeArray[k++] = a2[j];
                j++;
            }
        }
        return mergeArray;
    }

}
