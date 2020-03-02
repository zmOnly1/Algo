package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/15.
 */
public class RepeatNumber {

    /**
     * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
     * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
     * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || numbers.length != length) {
            return false;
        }
        Arrays.sort(numbers);
        int existNum = numbers[0];
        for (int i = 1; i < length; i++) {
            if (existNum == numbers[i]) {
                duplication[0] = existNum;
                return true;
            } else {
                existNum = numbers[i];
            }
        }
        return false;
    }
}
