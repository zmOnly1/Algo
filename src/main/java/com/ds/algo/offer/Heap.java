package com.ds.algo.offer;

import java.util.ArrayList;

/**
 * Created by zm on 2020/2/11.
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] input = new int[] {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(heap.GetLeastNumbers_Solution(input, 4));
    }

    private int count = 0;

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0) {
            return list;
        }

        int[] array = new int[k + 1];
        for (int val : input) {
            insertToHeap(val, array, k);
        }


        for (int i = 1; i <= count; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private void insertToHeap(int val, int[] array, int k) {
        if (count < k) {
            count++;
            array[count] = val;
            heapifyUp(array);
            return;
        }
        int max = array[1];
        if (val < max) {
            array[1] = val;
            heapifyDown(array);
        }
    }

    private void heapifyDown(int[] array) {
        int i = 1;
        while (i <= count / 2) {
            int maxIndex = i;
            if (array[2 * i] > array[maxIndex]) {
                maxIndex = 2 * i;
            }
            if (2 * i + 1 <= count && array[2 * i + 1] > array[maxIndex]) {
                maxIndex = 2 * i + 1;
            }
            if (i == maxIndex) {
                break;
            }
            swap(array, i, maxIndex);
            i = maxIndex;
        }

    }

    private void heapifyUp(int[] array) {
        int i = count;
        while (i / 2 >= 1) {
            if (array[i] < array[i / 2]) {
                break;
            }
            swap(array, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] array, int src, int dest) {
        int temp = array[src];
        array[src] = array[dest];
        array[dest] = temp;
    }

}
