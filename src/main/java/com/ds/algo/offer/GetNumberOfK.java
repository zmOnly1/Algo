package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class GetNumberOfK {

    public static void main(String[] args) {
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        int[] array = new int[] {1, 2, 3, 3, 3, 3, 4, 7};
        System.out.println(getNumberOfK.GetNumberOfK(array, 5));
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (k < array[0] || k > array[array.length - 1]) {
            return 0;
        }
        int index = binarySearch(array, k);
        if (index != -1) {
            int count = 1;
            int i = index + 1;
            while (i < array.length) {
                if (array[i++] == k) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
        return 0;
    }

    private int binarySearch(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == k) {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
