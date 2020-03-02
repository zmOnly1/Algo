package com.ds.algo;

import java.util.*;

/**
 * Created by zm on 2020/1/22.
 */
public class MyArray {

    private final int DEFAULT_LEN = 10;
    private int[] data;
    private int count;

    public MyArray() {
        data = new int[DEFAULT_LEN];
        count = 0;
    }

    public boolean add(int val) {
        if (count == data.length) {
            ensureCapacity();
        }
        data[count++] = val;
        return true;
    }

    private void ensureCapacity() {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    public static void main(String[] args) {
        MyArray array = new MyArray();
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }
        System.out.println(Arrays.toString(array.data));


    }

}
