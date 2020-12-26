package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/3/8.
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        //int[] array = {1, 3, 7, 3, 7, 7, 3};
        int[] array = {2, 2, 3, 2};
        System.out.println(singleNumber2.singleNumber(array));
    }

    /**
     * ������һ���������͵����飬������ֻ��һ��Ԫ��ֻ����һ�Σ�����Ԫ�ض��������Ρ�����Ҫ�ҳ�ֻ����һ�ε�Ԫ��
     * ���ӣ�https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a?f=discussion
     * ��Դ��ţ����
     */
    public int singleNumber(int[] A) {
        int ones = 0;//��¼ֻ���ֹ�1�ε�bits
        int twos = 0;//��¼ֻ���ֹ�2�ε�bits
        int threes;
        for (int t : A) {
            twos |= ones & t;//Ҫ�ڸ���onesǰ�����twos
            ones ^= t;
            threes = ones & twos;//ones��twos�ж�Ϊ1��������3��
            ones &= ~threes;//Ĩȥ������3�ε�bits
            twos &= ~threes;
        }
        return ones;
    }

}
